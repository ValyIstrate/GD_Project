package net.gamedesign.villagerquests.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.gamedesign.villagerquests.VillagerQuestsMod;
import net.gamedesign.villagerquests.item.ModItems;
import net.gamedesign.villagerquests.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = VillagerQuestsMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.NOBLE.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack_quest_1 = new ItemStack(ModItems.QUEST_TEST_1.get(), 1);

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack_quest_1,10,8,0.02F));
        } else if (event.getType() == ModVillagers.WIZARD.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack_quest_1 = new ItemStack(ModItems.QUEST_TEST_1.get(), 1);

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack_quest_1,10,8,0.02F));
        } else if (event.getType() == ModVillagers.GUARDIAN.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack_quest_1 = new ItemStack(ModItems.QUEST_TEST_1.get(), 1);
            ItemStack stack_quest_2 = new ItemStack(ModItems.QUEST_TEST_1.get(), 1);
            ItemStack stack_quest_3 = new ItemStack(ModItems.QUEST_TEST_1.get(), 1);

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack_quest_1,10,8,0.02F));

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    stack_quest_2,10,8,0.02F));

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15),
                    stack_quest_3,10,8,0.02F));
        } else if (event.getType() == ModVillagers.PROTECTOR.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack_quest_1 = new ItemStack(ModItems.QUEST_TEST_1.get(), 1);

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack_quest_1,10,8,0.02F));
        }
    }
}
