package fr.stylobow.iyc.screen;

import fr.stylobow.iyc.config.ClientConfig;
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
                            boolean current = ClientConfig.CLIENT.showKeystrokes.get();
                            ClientConfig.CLIENT.showKeystrokes.set(!current);
                            btn.setMessage(getKeystrokesText());
                        })
                .bounds(centerX - btnW / 2, startY, btnW, btnH)
                .build());

        this.addRenderableWidget(Button.builder(
                        getPositionText(),
                        (btn) -> {
                            ClientConfig.HudPosition current = ClientConfig.CLIENT.position.get();
                            int nextOrdinal = (current.ordinal() + 1) % ClientConfig.HudPosition.values().length;

                            ClientConfig.CLIENT.position.set(ClientConfig.HudPosition.values()[nextOrdinal]);
                            btn.setMessage(getPositionText());
                        })
                .bounds(centerX - btnW / 2, startY + 25, btnW, btnH)
                .build());

        this.addRenderableWidget(Button.builder(
                        getColorText(),
                        (btn) -> {
                            ClientConfig.HudColor current = ClientConfig.CLIENT.textColor.get();
                            int nextOrdinal = (current.ordinal() + 1) % ClientConfig.HudColor.values().length;

                            ClientConfig.CLIENT.textColor.set(ClientConfig.HudColor.values()[nextOrdinal]);
                            btn.setMessage(getColorText());
                        })
                .bounds(centerX - btnW / 2, startY + 50, btnW, btnH)
                .build());

        this.addRenderableWidget(Button.builder(Component.translatable("iyc.menu.back"), (btn) -> this.onClose())
                .bounds(centerX - 100, this.height - 29, 200, 20)
                .build());
    }

    private Component getKeystrokesText() {
        boolean isOn = ClientConfig.CLIENT.showKeystrokes.get();
        Component state = Component.literal(isOn ? "ON" : "OFF")
                .withStyle(isOn ? ChatFormatting.GREEN : ChatFormatting.RED);
        return Component.translatable("iyc.hud.keystrokes", state);
    }

    private Component getPositionText() {
        String key = "iyc.position." + ClientConfig.CLIENT.position.get().name().toLowerCase();
        return Component.translatable("iyc.hud.position", Component.translatable(key));
    }

    private Component getColorText() {
        String colorKey = "iyc.color." + ClientConfig.CLIENT.textColor.get().name().toLowerCase();
        return Component.translatable("iyc.hud.color", Component.translatable(colorKey));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
    }
}