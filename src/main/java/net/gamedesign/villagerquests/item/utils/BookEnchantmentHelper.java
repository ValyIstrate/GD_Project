package net.gamedesign.villagerquests.item.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.registries.ForgeRegistries;

public class BookEnchantmentHelper {

    public static ItemStack createFortune3Book() {
        ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
        return addEnchantmentToBook(book, Enchantments.BLOCK_FORTUNE, 3);
    }

    public static ItemStack createUnbreaking3Book() {
        ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
        return addEnchantmentToBook(enchantedBook, Enchantments.UNBREAKING, 3);
    }

    public static ItemStack createMendingBook() {
        ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
        return addEnchantmentToBook(enchantedBook, Enchantments.MENDING, 1);
    }

    private static ItemStack addEnchantmentToBook(ItemStack book, Enchantment enchantment, int level) {
        CompoundTag tag = book.getOrCreateTag();

        ListTag enchantmentsList;
        if (tag.contains("StoredEnchantments", 9)) {
            enchantmentsList = tag.getList("StoredEnchantments", 10);
        } else {
            enchantmentsList = new ListTag();
        }

        CompoundTag enchantmentTag = new CompoundTag();
        enchantmentTag.putString("id", ForgeRegistries.ENCHANTMENTS.getKey(enchantment).toString());
        enchantmentTag.putShort("lvl", (short) level);
        enchantmentsList.add(enchantmentTag);

        tag.put("StoredEnchantments", enchantmentsList);
        book.setTag(tag);

        return book;
    }
}
