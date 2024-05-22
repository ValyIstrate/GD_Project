package net.gamedesign.villagerquests.modetab;

import net.gamedesign.villagerquests.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TEST_TAB = new CreativeModeTab("queststab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.QUEST_WIZARD_ONE.get());
        }
    };
}
