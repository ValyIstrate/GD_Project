package net.gamedesign.villagerquests.villager;

import com.google.common.collect.ImmutableSet;
import net.gamedesign.villagerquests.VillagerQuestsMod;
import net.gamedesign.villagerquests.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, VillagerQuestsMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, VillagerQuestsMod.MOD_ID);

    public static final RegistryObject<PoiType> GUARDIAN_GUILD_POI = POI_TYPES.register("guardian_guild_stone",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.GUARDIAN_STONE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> GUARDIAN = VILLAGER_PROFESSIONS.register("guardian",
            () -> new VillagerProfession("guardian", x -> x.get() == GUARDIAN_GUILD_POI.get(),
                    x -> x.get() == GUARDIAN_GUILD_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, GUARDIAN_GUILD_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
