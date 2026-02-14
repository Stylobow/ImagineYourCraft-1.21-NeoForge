package fr.stylobow.iyn.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ClientConfig {

    public static final ModConfigSpec SPEC;
    public static final ClientConfig CLIENT;

    public final ModConfigSpec.BooleanValue showKeystrokes;
    public final ModConfigSpec.BooleanValue showCps;
    public final ModConfigSpec.EnumValue<HudPosition> position;
    public final ModConfigSpec.EnumValue<HudColor> textColor;

    static {
        final Pair<ClientConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(ClientConfig::new);
        SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    private ClientConfig(ModConfigSpec.Builder builder) {
        builder.push("keystrokes_hud");

        showKeystrokes = builder
                .comment("Afficher ou cacher le HUD")
                .define("showKeystrokes", true);

        showCps = builder
                .comment("Afficher les CPS")
                .define("showCps", true);

        position = builder
                .comment("Position du HUD sur l'écran")
                .defineEnum("position", HudPosition.TOP_LEFT);

        textColor = builder
                .comment("Couleur du texte")
                .defineEnum("color", HudColor.WHITE);

        builder.pop();
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
}