package net.gamedesign.villagerquests.item;

import net.gamedesign.villagerquests.VillagerQuestsMod;
import net.gamedesign.villagerquests.item.custom.QuestItem;
import net.gamedesign.villagerquests.item.utils.BookEnchantmentHelper;
import net.gamedesign.villagerquests.modetab.ModCreativeModeTab;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VillagerQuestsMod.MOD_ID);

    public static final RegistryObject<QuestItem> QUEST_WIZARD_ONE = ITEMS.register("quest_wizard_one",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve a stack of leather and you will get a Mending Enchantment Book!",
                    Items.LEATHER,
                    64,
                    BookEnchantmentHelper.createMendingBook().getItem(),
                    1));

    public static final RegistryObject<QuestItem> QUEST_WIZARD_TWO = ITEMS.register("quest_wizard_two",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve a stack of gold ingots and you will get a Fortune III Enchantment Book!",
                    Items.GOLD_INGOT,
                    64,
                    BookEnchantmentHelper.createFortune3Book().getItem(),
                    1));

    public static final RegistryObject<QuestItem> QUEST_WIZARD_THREE = ITEMS.register("quest_wizard_three",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve a stack of iron ingots and you will get a Unbreaking III Enchantment Book!",
                    Items.IRON_INGOT,
                    64,
                    BookEnchantmentHelper.createUnbreaking3Book().getItem(),
                    1));

    public static final RegistryObject<QuestItem> QUEST_NOBLE_ONE = ITEMS.register("quest_noble_one",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve one diamond and you will get a chain-mail chest-plate!",
                    Items.DIAMOND,
                    1,
                    Items.CHAINMAIL_CHESTPLATE,
                    1));

    public static final RegistryObject<QuestItem> QUEST_NOBLE_TWO = ITEMS.register("quest_noble_two",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve 5 emeralds and you will get a diamond!",
                    Items.EMERALD,
                    5,
                    Items.DIAMOND,
                    1));

    public static final RegistryObject<QuestItem> QUEST_NOBLE_THREE = ITEMS.register("quest_noble_three",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve 32 iron ingots and you will get one diamond!",
                    Items.IRON_INGOT,
                    32,
                    Items.DIAMOND,
                    1));

    public static final RegistryObject<QuestItem> QUEST_GUARDIAN_ONE = ITEMS.register("quest_guardian_one",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve 32 phantom membranes and you will get an elytra!",
                    Items.PHANTOM_MEMBRANE,
                    32,
                    Items.ELYTRA,
                    1));

    public static final RegistryObject<QuestItem> QUEST_GUARDIAN_TWO = ITEMS.register("quest_guardian_two",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve 5 pillager flags and you will get a totem of undying!",
                    Items.BLACK_BANNER,
                    5,
                    Items.TOTEM_OF_UNDYING,
                    1));

    public static final RegistryObject<QuestItem> QUEST_GUARDIAN_THREE = ITEMS.register("quest_guardian_three",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve one stack of prismarine shards and you will receive a trident!",
                    Items.PRISMARINE_SHARD,
                    64,
                    Items.TRIDENT,
                    1));

    public static final RegistryObject<QuestItem> QUEST_PROTECTOR_ONE = ITEMS.register("quest_protector_one",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve an end crystal and you will receive 16 blocks of ancient debris!",
                    Items.END_CRYSTAL,
                    1,
                    Items.ANCIENT_DEBRIS,
                    16));

    public static final RegistryObject<QuestItem> QUEST_PROTECTOR_TWO = ITEMS.register("quest_protector_two",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve 5 bottles of dragon breath and you will receive 5 pieces of netherite scrap!",
                    Items.DRAGON_BREATH,
                    5,
                    Items.NETHERITE_SCRAP,
                    5));

    public static final RegistryObject<QuestItem> QUEST_PROTECTOR_THREE = ITEMS.register("quest_protector_three",
            () -> new QuestItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1),
                    "Retrieve a nether star and you will receive 4 netherite ingots!",
                    Items.NETHER_STAR,
                    1,
                    Items.NETHERITE_INGOT,
                    4));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
