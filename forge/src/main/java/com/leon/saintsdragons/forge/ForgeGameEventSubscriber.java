package com.leon.saintsdragons.forge;

import com.leon.saintsdragons.common.SaintsDragonsCommon;
import com.leon.saintsdragons.server.entity.base.DragonEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.VanillaGameEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Bridges Minecraft 1.18.2's Forge game-event hook to the dragon hearing system.
 * 1.18.2 does not expose the later DynamicGameEventListener API.
 */
@Mod.EventBusSubscriber(modid = SaintsDragonsCommon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeGameEventSubscriber {
    private static final double MAX_DRAGON_HEARING_RANGE = 48.0D;

    private ForgeGameEventSubscriber() {
    }

    @SubscribeEvent
    public static void onVanillaGameEvent(VanillaGameEvent event) {
        if (!(event.getLevel() instanceof ServerLevel level)) {
            return;
        }

        BlockPos position = event.getEventPosition();
        AABB searchBounds = new AABB(position).inflate(MAX_DRAGON_HEARING_RANGE);
        for (DragonEntity dragon : level.getEntitiesOfClass(DragonEntity.class, searchBounds)) {
            dragon.handleHeardGameEvent(level, event.getVanillaEvent(), event.getCause(), position);
        }
    }
}
