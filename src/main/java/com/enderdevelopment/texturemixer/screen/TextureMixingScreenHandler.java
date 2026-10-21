package com.enderdevelopment.texturemixer.screen;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

public class TextureMixingScreenHandler extends ScreenHandler {
    public TextureMixingScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(TextureMixerMod.TEXTURE_MIXING_SCREEN_HANDLER_TYPE, syncId);
    }

    @Override
    public ItemStack quickMove(PlayerInventory playerInventory, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerInventory playerInventory) {
        return true;
    }
}