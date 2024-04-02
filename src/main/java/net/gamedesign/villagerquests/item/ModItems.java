package net.gamedesign.villagerquests.item;

import net.gamedesign.villagerquests.VillagerQuestsMod;
import net.gamedesign.villagerquests.item.custom.QuestItem;
import net.gamedesign.villagerquests.modetab.ModCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VillagerQuestsMod.MOD_ID);

    public static final RegistryObject<QuestItem> QUEST_TEST_1 = ITEMS.register("quest",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve 5 emeralds and you will get 1 diamond!"));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
