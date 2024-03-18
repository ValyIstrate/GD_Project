package net.gamedesign.villagerquests.item;

import net.gamedesign.villagerquests.VillagerQuestsMod;
import net.gamedesign.villagerquests.item.custom.QuestItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VillagerQuestsMod.MOD_ID);

    public static final RegistryObject<QuestItem> QUEST = ITEMS.register("quest",
            () -> new QuestItem(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
