package fr.stylobow.iyc.client.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.neoforged.fml.loading.FMLPaths;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class IYCConfig {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_DIR = new File(FMLPaths.CONFIGDIR.get().toFile(), "iyc");
    private static final File CONFIG_FILE = new File(CONFIG_DIR, "client_settings.json");

    public static ConfigData data = new ConfigData();

    public static void load() {
        if (!CONFIG_DIR.exists()) {
            CONFIG_DIR.mkdirs();
        }
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                ConfigData parsedData = GSON.fromJson(reader, ConfigData.class);
                if (parsedData != null) {
                    data = parsedData;
                } else {
                    save();
                }
            } catch (Exception e) {
                save();
            }
        } else {
            save();
        }
    }

    public static void save() {
        if (!CONFIG_DIR.exists()) {
            CONFIG_DIR.mkdirs();
        }
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(data, writer);
        } catch (Exception e) {
        }
    }

    public enum HudPosition {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
    }

    public enum HudColor {
        WHITE(0xFFFFFF),
        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF),
        YELLOW(0xFFFF00),
        PURPLE(0xA020F0),
        GOLD(0xFFAA00),
        BLACK(0x000000),
        CHROMA(0x000000);

        public final int hex;
        HudColor(int hex) { this.hex = hex; }
    }

    public static class ConfigData {
        public float musicVolume = 0.5f;
        public boolean showKeystrokes = false;
        public boolean showCps = false;
        public HudPosition keystrokesPosition = HudPosition.BOTTOM_RIGHT;
        public HudColor keystrokesColor = HudColor.WHITE;
        public String customSkinPath = "";
    }
}