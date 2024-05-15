package net.gamedesign.villagerquests.block;

import net.gamedesign.villagerquests.VillagerQuestsMod;
import net.gamedesign.villagerquests.block.custom.GuildStoneBlock;
import net.gamedesign.villagerquests.block.custom.QuestStoneBlock;
import net.gamedesign.villagerquests.item.ModItems;
import net.gamedesign.villagerquests.modetab.ModCreativeModeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, VillagerQuestsMod.MOD_ID);

    public static final RegistryObject<Block> QUEST_HANDLER = registerBlock("quest_handler_block",
            () -> new QuestStoneBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1f)), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> NOBLE_STONE = registerBlock("noble_guild_stone",
            () -> new GuildStoneBlock(BlockBehaviour.Properties.of(Material.METAL).
                    strength(6f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> WIZARD_STONE = registerBlock("wizard_guild_stone",
            () -> new GuildStoneBlock(BlockBehaviour.Properties.of(Material.METAL).
                    strength(6f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> GUARDIAN_STONE = registerBlock("guardian_guild_stone",
            () -> new GuildStoneBlock(BlockBehaviour.Properties.of(Material.METAL).
                    strength(6f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
