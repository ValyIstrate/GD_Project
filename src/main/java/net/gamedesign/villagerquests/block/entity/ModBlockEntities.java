package net.gamedesign.villagerquests.block.entity;

import net.gamedesign.villagerquests.VillagerQuestsMod;
import net.gamedesign.villagerquests.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, VillagerQuestsMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<QuestCompletedBlockEntity>> QUEST_STONE =
            BLOCK_ENTITIES.register("quest_stone", () ->
                    BlockEntityType.Builder.of(QuestCompletedBlockEntity::new,
                            ModBlocks.QUEST_HANDLER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
