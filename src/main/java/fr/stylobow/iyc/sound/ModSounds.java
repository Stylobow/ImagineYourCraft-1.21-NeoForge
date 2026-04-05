package fr.stylobow.iyc.sound;

import fr.stylobow.iyc.ImagineYourCraft;
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
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, ImagineYourCraft.MOD_ID);

    public static final Supplier<SoundEvent> TAKE_BACK_NIGHT = registerSoundEvent("record_take_back_night");
    public static final ResourceKey<JukeboxSong> TAKE_BACK_NIGHT_KEY = createSong("record_take_back_night");
    public static final Supplier<SoundEvent> ZOMBIES = registerSoundEvent("record_zombies");
    public static final ResourceKey<JukeboxSong> ZOMBIES_KEY = createSong("record_zombies");
    public static final Supplier<SoundEvent> CHUNKS = registerSoundEvent("record_chunks");
    public static final ResourceKey<JukeboxSong> CHUNKS_KEY = createSong("record_chunks");
    public static final Supplier<SoundEvent> CREEP = registerSoundEvent("record_creep");
    public static final ResourceKey<JukeboxSong> CREEP_KEY = createSong("record_creep");
    public static final Supplier<SoundEvent> NOFRAGAYS = registerSoundEvent("record_nofragays");
    public static final ResourceKey<JukeboxSong> NOFRAGAYS_KEY = createSong("record_nofragays");
    public static final Supplier<SoundEvent> SEAN_KEVIN = registerSoundEvent("record_sean_kevin");
    public static final ResourceKey<JukeboxSong> SEAN_KEVIN_KEY = createSong("record_sean_kevin");
    public static final Supplier<SoundEvent> GIVE = registerSoundEvent("record_give");
    public static final ResourceKey<JukeboxSong> GIVE_KEY = createSong("record_give");
    public static final Supplier<SoundEvent> PELLES = registerSoundEvent("record_pelles");
    public static final ResourceKey<JukeboxSong> PELLES_KEY = createSong("record_pelles");
    public static final Supplier<SoundEvent> GEEK = registerSoundEvent("record_geek");
    public static final ResourceKey<JukeboxSong> GEEK_KEY = createSong("record_geek");
    public static final Supplier<SoundEvent> ACTA = registerSoundEvent("record_acta");
    public static final ResourceKey<JukeboxSong> ACTA_KEY = createSong("record_acta");
    public static final Supplier<SoundEvent> TOUCH = registerSoundEvent("record_touch");
    public static final ResourceKey<JukeboxSong> TOUCH_KEY = createSong("record_touch");
    public static final Supplier<SoundEvent> MC_STYLE = registerSoundEvent("record_mc_style");
    public static final ResourceKey<JukeboxSong> MC_STYLE_KEY = createSong("record_mc_style");
    public static final Supplier<SoundEvent> BOUGE = registerSoundEvent("record_bouge");
    public static final ResourceKey<JukeboxSong> BOUGE_KEY = createSong("record_bouge");
    public static final Supplier<SoundEvent> SFR = registerSoundEvent("record_sfr");
    public static final ResourceKey<JukeboxSong> SFR_KEY = createSong("record_sfr");
    public static final Supplier<SoundEvent> REVENGE = registerSoundEvent("record_revenge");
    public static final ResourceKey<JukeboxSong> REVENGE_KEY = createSong("record_revenge");
    public static final Supplier<SoundEvent> FALLEN_KINGDOM = registerSoundEvent("record_fallen_kingdom");
    public static final ResourceKey<JukeboxSong> FALLEN_KINGDOM_KEY = createSong("record_fallen_kingdom");
    public static final Supplier<SoundEvent> TNT = registerSoundEvent("record_tnt");
    public static final ResourceKey<JukeboxSong> TNT_KEY = createSong("record_tnt");
    public static final Supplier<SoundEvent> GAGAOUTAI = registerSoundEvent("record_gagaoutai");
    public static final ResourceKey<JukeboxSong> GAGAOUTAI_KEY = createSong("record_gagaoutai");
    public static final Supplier<SoundEvent> THE_MINER = registerSoundEvent("record_the_miner");
    public static final ResourceKey<JukeboxSong> THE_MINER_KEY = createSong("record_the_miner");
    public static final Supplier<SoundEvent> DONT_MINE_AT_NIGHT = registerSoundEvent("record_dont_mine_at_night");
    public static final ResourceKey<JukeboxSong> DONT_MINE_AT_NIGHT_KEY = createSong("record_dont_mine_at_night");
    public static final Supplier<SoundEvent> MAUVAISE = registerSoundEvent("record_mauvaise");
    public static final ResourceKey<JukeboxSong> MAUVAISE_KEY = createSong("record_mauvaise");
    public static final Supplier<SoundEvent> GIRL_CRAFTY = registerSoundEvent("record_girl_crafty");
    public static final ResourceKey<JukeboxSong> GIRL_CRAFTY_KEY = createSong("record_girl_crafty");

    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(ImagineYourCraft.MOD_ID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(ImagineYourCraft.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
