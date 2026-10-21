package com.enderdevelopment.texturemixer;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import com.enderdevelopment.texturemixer.screen.TextureMixingScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TextureMixerMod implements ModInitializer {
    public static final String MOD_ID = "texturemixer";
    import com.enderdevelopment.texturemixer.screen.TextureMixingScreen;
import net.minecraft.client.option.KeyBind;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class TextureMixerMod implements ModInitializer {
    public static final String MOD_ID = "texturemixer";
    public static final ScreenHandlerType<TextureMixingScreenHandler> TEXTURE_MIXING_SCREEN_HANDLER_TYPE = new ScreenHandlerType<>(TextureMixingScreenHandler::new);
    public static KeyBind textureMixingKeyBind;

    @Override
    public void onInitialize() {
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(MOD_ID, "texture_mixing"), TEXTURE_MIXING_SCREEN_HANDLER_TYPE);

        textureMixingKeyBind = KeyBindHelper.registerKeyBind(new KeyBind(
                "key.texturemixer.texture_mixing",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_I,
                "category.texturemixer.texture_mixer"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (textureMixingKeyBind.wasPressed()) {
                if (client.player != null) {
                    client.setScreen(new TextureMixingScreen(new TextureMixingScreenHandler(0, client.player.getInventory()), client.player.getInventory(), Text.literal("Texture Mixing")));
                }
            }
        });
    }

    @Override
    public void onInitialize() {
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(MOD_ID, "texture_mixing"), TEXTURE_MIXING_SCREEN_HANDLER_TYPE);
    }
    public static final String MOD_ID = "texturemixer";
    private static KeyBinding importKeyBinding;

    @Override
    public void onInitialize() {
        // Register keybind for importing texture packs
        importKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.texturemixer.import",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_I,
                "category.texturemixer.texturemixer"
        ));

        // Register client tick event for keybind handling
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (importKeyBinding.wasPressed()) {
                // Handle texture pack import
                TexturePackImporter.importTexturePack(client);
            }
        });
    }
}