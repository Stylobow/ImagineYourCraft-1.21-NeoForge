package fr.stylobow.iyc.client.audio;

import fr.stylobow.iyc.client.config.IYCConfig;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.JavaSoundAudioDevice;
import javazoom.jl.player.Player;

import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class RadioManager {

    private static Player player;
    private static Thread playerThread;
    private static String currentRadio = "";
    private static CustomAudioDevice customDevice;

    public static void play(String urlStr, String radioName) {
        stop();
        currentRadio = radioName;

        playerThread = new Thread(() -> {
            try {
                URL url = URI.create(urlStr).toURL();
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                InputStream is = connection.getInputStream();

                if (!radioName.equals(currentRadio)) {
                    is.close();
                    return;
                }

                customDevice = new CustomAudioDevice();
                customDevice.setCustomVolume(IYCConfig.data.musicVolume);

                player = new Player(is, customDevice);

                if (!radioName.equals(currentRadio)) {
                    player.close();
                    return;
                }

                player.play();
            } catch (Exception e) {
                if (radioName.equals(currentRadio)) {
                    currentRadio = "";
                }
            }
        });

        playerThread.setContextClassLoader(RadioManager.class.getClassLoader());
        playerThread.setDaemon(true);
        playerThread.start();
    }

    public static void stop() {
        if (player != null) {
            player.close();
            player = null;
        }
        if (playerThread != null) {
            playerThread.interrupt();
            playerThread = null;
        }
        customDevice = null;
        currentRadio = "";
    }

    public static void setVolume(float volume) {
        IYCConfig.data.musicVolume = volume;
        IYCConfig.save();
        if (customDevice != null) {
            customDevice.setCustomVolume(volume);
        }
    }

    public static float getVolume() {
        return IYCConfig.data.musicVolume;
    }

    public static String getCurrentRadio() {
        return currentRadio;
    }

    private static class CustomAudioDevice extends JavaSoundAudioDevice {
        private float volume = 0.5f;

        public void setCustomVolume(float vol) {
            this.volume = Math.max(0.0f, Math.min(vol, 1.0f));
            updateVolume();
        }

        private void updateVolume() {
            try {
                Field sourceField = JavaSoundAudioDevice.class.getDeclaredField("source");
                sourceField.setAccessible(true);
                SourceDataLine source = (SourceDataLine) sourceField.get(this);
                if (source != null && source.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    FloatControl gainControl = (FloatControl) source.getControl(FloatControl.Type.MASTER_GAIN);
                    float dB = (float) (Math.log(this.volume <= 0.0f ? 0.0001f : this.volume) / Math.log(10.0) * 20.0);
                    gainControl.setValue(Math.max(gainControl.getMinimum(), Math.min(gainControl.getMaximum(), dB)));
                }
            } catch (Exception ignored) {
            }
        }

        @Override
        protected void createSource() throws JavaLayerException {
            super.createSource();
            updateVolume();
        }
    }
}