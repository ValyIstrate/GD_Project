package net.gamedesign.villagerquests;

import com.mojang.logging.LogUtils;
import net.gamedesign.villagerquests.block.ModBlocks;
import net.gamedesign.villagerquests.block.entity.ModBlockEntities;
import net.gamedesign.villagerquests.item.ModItems;
import net.gamedesign.villagerquests.screen.ModMenuTypes;
import net.gamedesign.villagerquests.screen.QuestStoneScreen;
import net.gamedesign.villagerquests.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(VillagerQuestsMod.MOD_ID)
public class VillagerQuestsMod {
    public static final String MOD_ID = "villagerquests";
    private static final Logger LOGGER = LogUtils.getLogger();

    public VillagerQuestsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.QUEST_STONE_MENU.get(), QuestStoneScreen::new);
        }
    }
}
