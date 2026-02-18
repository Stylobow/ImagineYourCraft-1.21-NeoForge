package fr.stylobow.iyn.sound;

import fr.stylobow.iyn.ImagineYourNight;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, ImagineYourNight.MOD_ID);

    public static final Supplier<SoundEvent> TAKE_BACK_NIGHT = registerSoundEvent("take_back_night");
    public static final ResourceKey<JukeboxSong> TAKE_BACK_NIGHT_KEY = createSong("take_back_night");
    public static final Supplier<SoundEvent> ZOMBIES = registerSoundEvent("zombies");
    public static final ResourceKey<JukeboxSong> ZOMBIES_KEY = createSong("zombies");
    public static final Supplier<SoundEvent> CHUNKS = registerSoundEvent("chunks");
    public static final ResourceKey<JukeboxSong> CHUNKS_KEY = createSong("chunks");
    public static final Supplier<SoundEvent> CREEP = registerSoundEvent("creep");
    public static final ResourceKey<JukeboxSong> CREEP_KEY = createSong("creep");
    public static final Supplier<SoundEvent> NOFRAGAYS = registerSoundEvent("nofragays");
    public static final ResourceKey<JukeboxSong> NOFRAGAYS_KEY = createSong("nofragays");
    public static final Supplier<SoundEvent> SEAN_KEVIN = registerSoundEvent("sean_kevin");
    public static final ResourceKey<JukeboxSong> SEAN_KEVIN_KEY = createSong("sean_kevin");
    public static final Supplier<SoundEvent> GIVE = registerSoundEvent("give");
    public static final ResourceKey<JukeboxSong> GIVE_KEY = createSong("give");
    public static final Supplier<SoundEvent> PELLES = registerSoundEvent("pelles");
    public static final ResourceKey<JukeboxSong> PELLES_KEY = createSong("pelles");
    public static final Supplier<SoundEvent> GEEK = registerSoundEvent("geek");
    public static final ResourceKey<JukeboxSong> GEEK_KEY = createSong("geek");
    public static final Supplier<SoundEvent> ACTA = registerSoundEvent("acta");
    public static final ResourceKey<JukeboxSong> ACTA_KEY = createSong("acta");
    public static final Supplier<SoundEvent> TOUCH = registerSoundEvent("touch");
    public static final ResourceKey<JukeboxSong> TOUCH_KEY = createSong("touch");
    public static final Supplier<SoundEvent> MC_STYLE = registerSoundEvent("mc_style");
    public static final ResourceKey<JukeboxSong> MC_STYLE_KEY = createSong("mc_style");

    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(ImagineYourNight.MOD_ID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(ImagineYourNight.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
