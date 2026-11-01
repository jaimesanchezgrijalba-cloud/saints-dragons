package com.leon.saintsdragons.common.registry;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.LivingEntity;

/**
 * Minecraft 1.18.2 does not have the datapack-driven damage_type registry.
 * Preserve the Raevyx lightning damage identity and attacker attribution with
 * the legacy entity damage source API.
 */
public final class ModDamageTypes {
    private ModDamageTypes() {
    }

    public static DamageSource raevyxLightning(LivingEntity attacker) {
        return new EntityDamageSource("saintsdragons.raevyx_lightning", attacker).setMagic();
    }
}
