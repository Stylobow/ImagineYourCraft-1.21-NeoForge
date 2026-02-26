package fr.stylobow.iyc.screen;

import fr.stylobow.iyc.client.config.IYCConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.util.tinyfd.TinyFileDialogs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class CustomScreen extends Screen {

    private Button skinButton;
    private String errorMessage = "";

    public CustomScreen(Component title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();
        this.errorMessage = "";

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

        this.skinButton = Button.builder(
                        getSkinText(),
                        (btn) -> {
                            openFileChooser();
                        })
                .bounds(centerX - btnW / 2, startY + 75, btnW, btnH)
                .build();
        this.addRenderableWidget(this.skinButton);

        this.addRenderableWidget(Button.builder(Component.translatable("iyc.menu.back"), (btn) -> this.onClose())
                .bounds(centerX - 100, this.height - 29, 200, 20)
                .build());
    }

    private void openFileChooser() {
        new Thread(() -> {
            try (MemoryStack stack = MemoryStack.stackPush()) {
                PointerBuffer filters = stack.mallocPointer(1);
                filters.put(stack.UTF8("*.png"));
                filters.flip();

                String result = TinyFileDialogs.tinyfd_openFileDialog(
                        "Choose a skin (.png)",
                        "",
                        filters,
                        "Images PNG",
                        false
                );

                if (result != null) {
                    try {
                        File file = new File(result);
                        BufferedImage bimg = ImageIO.read(file);
                        if (bimg == null) throw new Exception();

                        int w = bimg.getWidth();
                        int h = bimg.getHeight();

                        boolean isValidWidth = (w > 0 && w % 64 == 0);
                        boolean isValidHeight = (h == w || h == w / 2);

                        if (!isValidWidth || !isValidHeight) {
                            if (this.minecraft != null) {
                                this.minecraft.execute(() -> this.errorMessage = "Invalid format (" + w + "x" + h + ") !");
                            }
                            return;
                        }
                    } catch (Exception e) {
                        if (this.minecraft != null) {
                            this.minecraft.execute(() -> this.errorMessage = "Corrupted image file!");
                        }
                        return;
                    }

                    IYCConfig.data.customSkinPath = result;
                    IYCConfig.save();

                    if (this.minecraft != null) {
                        this.minecraft.execute(() -> {
                            this.errorMessage = "";
                            this.skinButton.setMessage(getSkinText());
                            fr.stylobow.iyc.client.skin.CustomSkinManager.applySkin();
                        });
                    }
                }
            } catch (Exception ignored) {
            }
        }).start();
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

    private Component getSkinText() {
        String path = IYCConfig.data.customSkinPath;
        if (path == null || path.isEmpty()) {
            return Component.literal("Skin: Défaut");
        } else {
            File file = new File(path);
            String name = file.getName();
            if (name.toLowerCase().endsWith(".png")) {
                name = name.substring(0, name.length() - 4);
            }
            return Component.literal("Skin: " + name);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);

        int posX = this.width / 2 + 160;
        int posY = 150;

        if (!this.errorMessage.isEmpty()) {
            guiGraphics.drawCenteredString(this.font, Component.literal(this.errorMessage).withStyle(ChatFormatting.RED), posX, posY - 125, 0xFFFFFF);
        }

        if (this.minecraft != null && this.minecraft.player != null) {
            int scale = 50;

            int boxLeft = posX - 50;
            int boxTop = posY - 110;
            int boxRight = posX + 50;
            int boxBottom = posY + 20;

            float yOffset = 0.0625f;

            InventoryScreen.renderEntityInInventoryFollowsMouse(
                    guiGraphics,
                    boxLeft,
                    boxTop,
                    boxRight,
                    boxBottom,
                    scale,
                    yOffset,
                    (float) mouseX,
                    (float) mouseY,
                    this.minecraft.player
            );
        }
    }
}