package com.enderdevelopment.texturemixer;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class TextureMixingMenu extends Screen {
    protected TextureMixingMenu() {
        super(Text.literal("Texture Mixing Menu"));
    }

    @Override
    protected void init() {
        // Add buttons for different texture categories
        this.addDrawableChild(new ButtonWidget.Builder(Text.literal("Gaps"), button -> {
            // Handle gaps category selection
        }).dimensions(this.width / 2 - 100, this.height / 2 - 60, 200, 20).build());

        // Add more category buttons...
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
    }
}