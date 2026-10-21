package com.enderdevelopment.texturemixer.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import com.enderdevelopment.texturemixer.TextureMixerMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;

public class TextureMixingScreen extends HandledScreen<TextureMixingScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("texturemixer", "textures/gui/texture_mixing.png");
    private static final Identifier MIXED_TEXTURE = new Identifier("texturemixer", "textures/gui/mixed_texture.png");

    public TextureMixingScreen(TextureMixingScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        addDrawableChild(new ButtonWidget.Builder(Text.literal("Mix Textures"), button -> mixTextures()).dimensions(width / 2 - 50, height / 2 + 20, 100, 20).build());
    }

    import com.enderdevelopment.texturemixer.TextureMixerMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;

public class TextureMixingScreen extends HandledScreen<TextureMixingScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("texturemixer", "textures/gui/texture_mixing.png");
    private static final Identifier MIXED_TEXTURE = new Identifier("texturemixer", "textures/gui/mixed_texture.png");

    public TextureMixingScreen(TextureMixingScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        addDrawableChild(new ButtonWidget.Builder(Text.literal("Mix Textures"), button -> mixTextures()).dimensions(width / 2 - 50, height / 2 + 20, 100, 20).build());
    }

    private void mixTextures() {
        // Placeholder for texture mixing logic
        // In a real implementation, you would mix the textures from different packs here
        // For now, we'll just create a simple mixed texture
        NativeImage mixedImage = new NativeImage(256, 256, false);
        for (int x = 0; x < 256; x++) {
            for (int y = 0; y < 256; y++) {
                mixedImage.setColor(x, y, (x % 256) << 16 | (y % 256) << 8 | 255);
            }
        }

        MinecraftClient.getInstance().getTextureManager().registerTexture(MIXED_TEXTURE, new NativeImageBackedTexture(mixedImage));
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        // Draw the mixed texture
        if (MinecraftClient.getInstance().getTextureManager().getTexture(MIXED_TEXTURE) != null) {
            RenderSystem.setShaderTexture(0, MIXED_TEXTURE);
            context.drawTexture(MIXED_TEXTURE, x + 10, y + 10, 0, 0, 256, 256, 256, 256);
        }
    }
        // Placeholder for texture mixing logic
        // In a real implementation, you would mix the textures from different packs here
        // For now, we'll just create a simple mixed texture
        NativeImage mixedImage = new NativeImage(256, 256, false);
        for (int x = 0; x < 256; x++) {
            for (int y = 0; y < 256; y++) {
                mixedImage.setColor(x, y, (x % 256) << 16 | (y % 256) << 8 | 255);
            }
        }

        MinecraftClient.getInstance().getTextureManager().registerTexture(MIXED_TEXTURE, new NativeImageBackedTexture(mixedImage));
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        // Draw the mixed texture
        if (MinecraftClient.getInstance().getTextureManager().getTexture(MIXED_TEXTURE) != null) {
            RenderSystem.setShaderTexture(0, MIXED_TEXTURE);
            context.drawTexture(MIXED_TEXTURE, x + 10, y + 10, 0, 0, 256, 256, 256, 256);
        }
    }
    private static final Identifier TEXTURE = new Identifier("texturemixer", "textures/gui/texture_mixing.png");

    public TextureMixingScreen(TextureMixingScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}