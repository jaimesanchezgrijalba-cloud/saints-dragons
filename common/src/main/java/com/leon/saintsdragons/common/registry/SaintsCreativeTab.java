package com.leon.saintsdragons.common.registry;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class SaintsCreativeTab {
    /**
     * Minecraft 1.18.2 creates creative tabs directly; they are not registry entries.
     * Weapon-specific entries have intentionally been left out of this port.
     */
    public static final CreativeModeTab SD_CREATIVE_TAB = new CreativeModeTab("saintsdragons") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RAEVYX_BINDER.get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            super.fillItemList(items);
            items.add(new ItemStack(ModItems.RAEVYX_BINDER.get()));
            items.add(new ItemStack(ModItems.CINDERVANE_BINDER.get()));
            items.add(new ItemStack(ModItems.STEGONAUT_BINDER.get()));
            items.add(new ItemStack(ModItems.VARASUCHUS_BINDER.get()));
            items.add(new ItemStack(ModItems.IGNIVORUS_BINDER.get()));
            items.add(new ItemStack(ModItems.VOLITANS_BINDER.get()));
            items.add(new ItemStack(ModItems.NULLJAW_BINDER.get()));
            items.add(new ItemStack(ModItems.ATROXIIA_BINDER.get()));
            items.add(new ItemStack(ModItems.DRACONIAN_CONTROLLER.get()));
            items.add(new ItemStack(ModItems.DRACONIC_CODEX.get()));
            items.add(new ItemStack(ModItems.DRAGON_BRUSH.get()));
            items.add(new ItemStack(ModItems.GOLDEN_DRAGON_BRUSH.get()));
            items.add(new ItemStack(ModItems.SCALE_PLUCKER.get()));
            items.add(new ItemStack(ModItems.HEARTY_DRAGON_MEAL.get()));
            items.add(new ItemStack(ModItems.CREATIVE_DRAGON_TAME_MEAL.get()));
            items.add(new ItemStack(ModItems.CREATIVE_DRAGON_GENDER_WAND.get()));
            items.add(new ItemStack(ModItems.CREATIVE_DRAGON_VARIANT_BRUSH.get()));
            items.add(new ItemStack(ModItems.RAW_MOOP.get()));
            items.add(new ItemStack(ModItems.COOKED_MOOP.get()));
            items.add(new ItemStack(ModItems.BUCKET_OF_MOOP.get()));
            items.add(new ItemStack(ModItems.RAW_MOSSBACK.get()));
            items.add(new ItemStack(ModItems.COOKED_MOSSBACK.get()));
            items.add(new ItemStack(ModItems.RAEVYX_SCALE.get()));
            items.add(new ItemStack(ModItems.RAEVYX_WING_HIDE.get()));
            items.add(new ItemStack(ModItems.RAEVYX_WINGTALON.get()));
            items.add(new ItemStack(ModItems.CINDERVANE_SCALE.get()));
            items.add(new ItemStack(ModItems.STEGONAUT_SCALE.get()));
            items.add(new ItemStack(ModItems.VARASUCHUS_SCALE.get()));
            items.add(new ItemStack(ModItems.IGNIVORUS_SCALE.get()));
            items.add(new ItemStack(ModItems.IGNIVORUS_TOOTH.get()));
            items.add(new ItemStack(ModItems.IGNIVORUS_WING_HIDE.get()));
            items.add(new ItemStack(ModItems.IGNIVORUS_HEART.get()));
            items.add(new ItemStack(ModItems.VOLITANS_SCALE.get()));
            items.add(new ItemStack(ModItems.VOLITANS_SPINE.get()));
            items.add(new ItemStack(ModItems.ATROXIIA_SCALE.get()));
            items.add(new ItemStack(ModItems.DRACONIAN_FLESH.get()));
            items.add(new ItemStack(ModItems.RAEVYX_EGG.get()));
            items.add(new ItemStack(ModItems.CINDERVANE_EGG.get()));
            items.add(new ItemStack(ModItems.STEGONAUT_EGG.get()));
            items.add(new ItemStack(ModItems.VARASUCHUS_EGG.get()));
            items.add(new ItemStack(ModItems.IGNIVORUS_EGG.get()));
            items.add(new ItemStack(ModItems.VOLITANS_EGG.get()));
            items.add(new ItemStack(ModItems.ATROXIIA_EGG.get()));
            items.add(new ItemStack(ModItems.IVY_OCTOPUS_PLUSHIE.get()));
            items.add(new ItemStack(ModItems.SEARING_COAL.get()));
            items.add(new ItemStack(ModItems.ANCIENT_DRAGONITE_FRAGMENT.get()));
            items.add(new ItemStack(ModItems.DRAGON_SEAL_STONE.get()));
            items.add(new ItemStack(ModItems.DRAGON_BINDER_CORE.get()));
            items.add(new ItemStack(ModItems.RAW_WORLDROOT.get()));
            items.add(new ItemStack(ModItems.WORLDROOT_INGOT.get()));
            items.add(new ItemStack(ModItems.WORLDROOT_PICKAXE.get()));
            items.add(new ItemStack(ModItems.WORLDROOT_AXE.get()));
            items.add(new ItemStack(ModItems.WORLDROOT_SHOVEL.get()));
            items.add(new ItemStack(ModItems.WORLDROOT_HOE.get()));
            items.add(new ItemStack(ModItems.DRAGONHEART_CHUNK.get()));
            items.add(new ItemStack(ModItems.DRAGONHEART_ALLOY.get()));
            items.add(new ItemStack(ModArmors.DRACONIAN_HELMET.get()));
            items.add(new ItemStack(ModArmors.DRACONIAN_CHESTPLATE.get()));
            items.add(new ItemStack(ModArmors.DRACONIAN_LEGGINGS.get()));
            items.add(new ItemStack(ModArmors.DRACONIAN_BOOTS.get()));
            items.add(new ItemStack(ModArmors.BLOOD_TEMPEST_HELMET.get()));
            items.add(new ItemStack(ModArmors.BLOOD_TEMPEST_CHESTPLATE.get()));
            items.add(new ItemStack(ModArmors.BLOOD_TEMPEST_LEGGINGS.get()));
            items.add(new ItemStack(ModArmors.BLOOD_TEMPEST_BOOTS.get()));
            items.add(new ItemStack(ModArmors.DRAGONLORD_HELMET.get()));
            items.add(new ItemStack(ModArmors.DRAGONLORD_CHESTPLATE.get()));
            items.add(new ItemStack(ModArmors.DRAGONLORD_LEGGINGS.get()));
            items.add(new ItemStack(ModArmors.DRAGONLORD_BOOTS.get()));
            items.add(new ItemStack(ModPotionItems.POTION_OF_TIDEGUARD.get()));
            items.add(new ItemStack(ModPotionItems.POTION_OF_SEARING.get()));
            items.add(new ItemStack(ModItems.BLEEDING_BOLT_MUSIC_DISC.get()));
            items.add(new ItemStack(ModItems.MOSSBACK_MUSIC_MUSIC_DISC.get()));
            items.add(new ItemStack(ModItems.IGNIVORUS_INCUBATOR_BLOCK.get()));
            items.add(new ItemStack(ModItems.DRAGONHEART_ORE.get()));
            items.add(new ItemStack(ModItems.DRAGONHEART_ALLOY_BLOCK.get()));
            items.add(new ItemStack(ModItems.DRAGONHEART_BLOCK.get()));
            items.add(new ItemStack(ModItems.DEEPSLATE_WORLDROOT_ORE.get()));
            items.add(new ItemStack(ModItems.WORLDROOT_BLOCK.get()));
            items.add(new ItemStack(ModItems.RAW_WORLDROOT_BLOCK.get()));
            items.add(new ItemStack(ModItems.DRACONIAN_PELLUCIDA.get()));
            items.add(new ItemStack(ModItems.DRACONIAN_NUCLEUS.get()));
            items.add(new ItemStack(ModItems.DRACONIC_CRUCIBLE.get()));
            items.add(new ItemStack(ModItems.RAEVYX_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.CINDERVANE_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.STEGONAUT_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.VARASUCHUS_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.IGNIVORUS_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.VOLITANS_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.NULLJAW_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.ATROXIIA_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.MOSSBACK_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.LATCHER_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.WINGED_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.WHETTLED_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.DRACONIAN_SWARM_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.MOOP_SPAWN_EGG.get()));
            items.add(new ItemStack(ModItems.IVY_THE_MERCHANT_SPAWN_EGG.get()));
        }
    };

    private SaintsCreativeTab() {
    }

    public static void register() {
        // Loading this class creates and registers the 1.18.2 CreativeModeTab instance.
    }
}
