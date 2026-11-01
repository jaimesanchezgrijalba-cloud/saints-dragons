package com.leon.saintsdragons.common.registry;

import com.leon.saintsdragons.common.SaintsDragonsCommon;
import com.leon.saintsdragons.common.recipe.DraconicCrucibleShapedRecipe;
import com.leon.saintsdragons.common.recipe.DraconicCrucibleSmeltingRecipe;
import com.leon.saintsdragons.platform.RegistryHelper;
import com.leon.saintsdragons.platform.Services;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public final class ModRecipes {
    private static final RegistryHelper.RegistryWrapper<RecipeSerializer<?>> SERIALIZERS =
            Services.PLATFORM.getRegistryHelper().create(
                    ForgeRegistries.Keys.RECIPE_SERIALIZERS, () -> null, SaintsDragonsCommon.MOD_ID);

    public static final Supplier<RecipeType<DraconicCrucibleShapedRecipe>> DRACONIC_CRUCIBLE_SHAPED_TYPE =
            () -> simpleType("draconic_crucible");
    public static final Supplier<RecipeSerializer<DraconicCrucibleShapedRecipe>> DRACONIC_CRUCIBLE_SHAPED_SERIALIZER =
            SERIALIZERS.register("draconic_crucible", DraconicCrucibleShapedRecipe.Serializer::new);

    public static final Supplier<RecipeType<DraconicCrucibleSmeltingRecipe>> DRACONIC_CRUCIBLE_SMELTING_TYPE =
            () -> simpleType("draconic_crucible_smelting");
    public static final Supplier<RecipeSerializer<DraconicCrucibleSmeltingRecipe>> DRACONIC_CRUCIBLE_SMELTING_SERIALIZER =
            SERIALIZERS.register("draconic_crucible_smelting", DraconicCrucibleSmeltingRecipe.Serializer::new);

    private ModRecipes() {
    }

    public static void register() {
        SERIALIZERS.register();
    }

    private static <T extends Recipe<?>> RecipeType<T> simpleType(String name) {
        return new RecipeType<>() {
            @Override
            public String toString() {
                return SaintsDragonsCommon.MOD_ID + ":" + name;
            }
        };
    }
}
