package com.leon.saintsdragons.common.registry;

import com.leon.saintsdragons.common.SaintsDragonsCommon;
import com.leon.saintsdragons.platform.RegistryHelper;
import com.leon.saintsdragons.platform.Services;
import com.leon.saintsdragons.server.menu.IvyInventoryMenu;
import com.leon.saintsdragons.server.menu.DragonInventoryMenu;
import com.leon.saintsdragons.server.menu.DraconicCrucibleMenu;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModMenus {
    private static final RegistryHelper.RegistryWrapper<MenuType<?>> REGISTER =
            Services.PLATFORM.getRegistryHelper()
                    .create(ForgeRegistries.Keys.CONTAINER_TYPES, () -> null, SaintsDragonsCommon.MOD_ID);

    public static final Supplier<MenuType<DragonInventoryMenu>> DRAGON_INVENTORY =
            REGISTER.register("dragon_inventory",
                    () -> new MenuType<>(DragonInventoryMenu::new, FeatureFlags.DEFAULT_FLAGS));

    public static final Supplier<MenuType<IvyInventoryMenu>> IVY_INVENTORY =
            REGISTER.register("ivy_inventory",
                    () -> new MenuType<>(IvyInventoryMenu::new, FeatureFlags.DEFAULT_FLAGS));

    public static final Supplier<MenuType<DraconicCrucibleMenu>> DRACONIC_CRUCIBLE =
            REGISTER.register("draconic_crucible",
                    () -> new MenuType<>(DraconicCrucibleMenu::new, FeatureFlags.DEFAULT_FLAGS));

    private ModMenus() {
    }

    public static void register() {
        REGISTER.register();
    }
}
