package net.gamedesign.villagerquests.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class QuestItem extends Item {
    private String recipe;

    public QuestItem(Properties properties, String recipe) {
        super(properties);
        this.recipe = recipe;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if (!level.isClientSide() && interactionHand == InteractionHand.MAIN_HAND) {
            // at the moment, just show a message
            outputMessage(player);
            player.getCooldowns().addCooldown(this, 20);
            // set a cool down
        }

        return super.use(level, player, interactionHand);
    }

    private void outputMessage(Player player) {
        player.sendSystemMessage(Component.literal(this.recipe));
    }

    @Override
    public void appendHoverText(ItemStack itemStack,
                                @Nullable Level level,
                                List<Component> components,
                                TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.literal("Right click to read the received quest")
                    .withStyle(ChatFormatting.BLUE));
        } else {
            components.add(Component.literal("Press SHIFT for more info")
                    .withStyle(ChatFormatting.GREEN));
        }

        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }
}
