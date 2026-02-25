package fr.stylobow.iyc.screen;

import fr.stylobow.iyc.client.config.IYCConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class CustomScreen extends Screen {

    public CustomScreen(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();

        int centerX = this.width / 2;
        int startY = 60;
        int btnW = 150;
        int btnH = 20;

        this.addRenderableWidget(Button.builder(
                        getKeystrokesText(),
                        (btn) -> {
                            IYCConfig.data.showKeystrokes = !IYCConfig.data.showKeystrokes;
                            IYCConfig.save();
                            btn.setMessage(getKeystrokesText());
                        })
                .bounds(centerX - btnW / 2, startY, btnW, btnH)
                .build());

        this.addRenderableWidget(Button.builder(
                        getPositionText(),
                        (btn) -> {
                            IYCConfig.HudPosition current = IYCConfig.data.keystrokesPosition;
                            int nextOrdinal = (current.ordinal() + 1) % IYCConfig.HudPosition.values().length;
                            IYCConfig.data.keystrokesPosition = IYCConfig.HudPosition.values()[nextOrdinal];
                            IYCConfig.save();
                            btn.setMessage(getPositionText());
                        })
                .bounds(centerX - btnW / 2, startY + 25, btnW, btnH)
                .build());

        this.addRenderableWidget(Button.builder(
                        getColorText(),
                        (btn) -> {
                            IYCConfig.HudColor current = IYCConfig.data.keystrokesColor;
                            int nextOrdinal = (current.ordinal() + 1) % IYCConfig.HudColor.values().length;
                            IYCConfig.data.keystrokesColor = IYCConfig.HudColor.values()[nextOrdinal];
                            IYCConfig.save();
                            btn.setMessage(getColorText());
                        })
                .bounds(centerX - btnW / 2, startY + 50, btnW, btnH)
                .build());

        this.addRenderableWidget(Button.builder(Component.translatable("iyc.menu.back"), (btn) -> this.onClose())
                .bounds(centerX - 100, this.height - 29, 200, 20)
                .build());
    }

    private Component getKeystrokesText() {
        boolean isOn = IYCConfig.data.showKeystrokes;
        Component state = Component.literal(isOn ? "ON" : "OFF")
                .withStyle(isOn ? ChatFormatting.GREEN : ChatFormatting.RED);
        return Component.translatable("iyc.hud.keystrokes", state);
    }

    private Component getPositionText() {
        String key = "iyc.position." + IYCConfig.data.keystrokesPosition.name().toLowerCase();
        return Component.translatable("iyc.hud.position", Component.translatable(key));
    }

    private Component getColorText() {
        String colorKey = "iyc.color." + IYCConfig.data.keystrokesColor.name().toLowerCase();
        return Component.translatable("iyc.hud.color", Component.translatable(colorKey));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
    }
}