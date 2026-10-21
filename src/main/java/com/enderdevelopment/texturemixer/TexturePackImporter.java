package com.enderdevelopment.texturemixer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TexturePackImporter {
    public static void importTexturePack(MinecraftClient client) {
        client.setScreen(new TexturePackImportScreen(client.currentScreen));
    }

    private static class TexturePackImportScreen extends Screen {
        private final Screen parent;
        private File selectedFile;

        protected TexturePackImportScreen(Screen parent) {
            super(Text.literal("Import Texture Pack"));
            this.parent = parent;
        }

        @Override
        protected void init() {
            this.addDrawableChild(new ButtonWidget.Builder(Text.literal("Browse"), button -> {
                // Open file chooser dialog
                // This is a placeholder - actual implementation would require platform-specific code
                // For now, we'll just simulate selecting a file
                selectedFile = new File("path/to/selected/texturepack.zip");
            }).dimensions(this.width / 2 - 100, this.height / 2 - 10, 200, 20).build());

            this.addDrawableChild(new ButtonWidget.Builder(Text.literal("Import"), button -> {
                if (selectedFile != null && selectedFile.exists()) {
                    try {
                        // Copy the selected file to the texture packs directory
                        File destination = new File(MinecraftClient.getInstance().runDirectory, "resourcepacks" + File.separator + selectedFile.getName());
                        Files.copy(selectedFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        
                        // Reload resource packs
                        MinecraftClient.getInstance().getResourcePackManager().scanPacks();
                        
                        // Close the screen
                        this.client.setScreen(parent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).dimensions(this.width / 2 - 100, this.height / 2 + 20, 200, 20).build());

            this.addDrawableChild(new ButtonWidget.Builder(Text.literal("Cancel"), button -> {
                this.client.setScreen(parent);
            }).dimensions(this.width / 2 - 100, this.height / 2 + 50, 200, 20).build());
        }
    }
}