package com.leon.saintsdragons.forge.world;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.leon.saintsdragons.common.SaintsDragonsCommon;
import com.leon.saintsdragons.common.config.SaintsDragonsConfig;
import com.leon.saintsdragons.common.registry.ModEntities;
import com.leon.saintsdragons.common.registry.ModTags;
import com.leon.saintsdragons.common.world.DragonSpawnRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Forge 1.18.2 world-generation hook. Forge biome modifiers were added after
 * this Minecraft version, so this class injects the mod's natural spawns while
 * each biome is assembled.
 */
public final class ForgeBiomeLoadingHandler {
    private static final String TAG_RESOURCE_ROOT = "data/saintsdragons/tags/worldgen/biome/";
    private static final Map<ResourceLocation, Set<ResourceLocation>> DIRECT_BIOME_TAGS = loadDirectBiomeTags();

    private ForgeBiomeLoadingHandler() {
    }

    public static void onBiomeLoading(BiomeLoadingEvent event) {
        ResourceLocation biomeId = event.getName();
        if (biomeId == null) {
            return;
        }

        for (DragonSpawnRegistry.DragonSpawnEntry entry : DragonSpawnRegistry.getAll()) {
            int weight = entry.weight().getAsInt();
            if (weight <= 0 || !matchesBiome(biomeId, event.getCategory(), entry.biomeTag())) {
                continue;
            }
            addSpawn(event, entry.category(), entry.entityType().get(), weight,
                    entry.minGroupSize().getAsInt(), entry.maxGroupSize().getAsInt());
        }

        if (SaintsDragonsConfig.isMoopSpawningEnabled()
                && matchesBiome(biomeId, event.getCategory(), ModTags.Biomes.HAS_MOOP)) {
            addSpawn(event, MobCategory.WATER_AMBIENT, ModEntities.MOOP.get(),
                    SaintsDragonsConfig.MOOP_SPAWN_WEIGHT.get(),
                    SaintsDragonsConfig.MOOP_MIN_GROUP_SIZE.get(),
                    SaintsDragonsConfig.MOOP_MAX_GROUP_SIZE.get());
        }

        if (SaintsDragonsConfig.isMossbackSpawningEnabled()
                && matchesBiome(biomeId, event.getCategory(), ModTags.Biomes.HAS_MOSSBACK)) {
            addSpawn(event, MobCategory.CREATURE, ModEntities.MOSSBACK.get(),
                    SaintsDragonsConfig.MOSSBACK_SPAWN_WEIGHT.get(),
                    SaintsDragonsConfig.MOSSBACK_MIN_GROUP_SIZE.get(),
                    SaintsDragonsConfig.MOSSBACK_MAX_GROUP_SIZE.get());
        }
    }

    private static void addSpawn(BiomeLoadingEvent event, MobCategory category, EntityType<?> entityType,
                                 int weight, int minGroupSize, int maxGroupSize) {
        if (weight <= 0 || minGroupSize <= 0 || maxGroupSize <= 0) {
            return;
        }
        int min = Math.min(minGroupSize, maxGroupSize);
        int max = Math.max(minGroupSize, maxGroupSize);

        @SuppressWarnings("unchecked")
        EntityType<? extends Mob> mobType = (EntityType<? extends Mob>) entityType;

        boolean alreadyPresent = event.getSpawns().getSpawner(category).stream()
                .anyMatch(existing -> existing.type == entityType);
        if (!alreadyPresent) {
            event.getSpawns().addSpawn(category, new MobSpawnSettings.SpawnerData(mobType, weight, min, max));
        }
    }

    private static boolean matchesBiome(ResourceLocation biomeId, Biome.BiomeCategory category,
                                        TagKey<Biome> biomeTag) {
        Set<ResourceLocation> direct = DIRECT_BIOME_TAGS.get(biomeTag.location());
        if (direct != null && direct.contains(biomeId)) {
            return true;
        }

        // In 1.18.2 BiomeLoadingEvent exposes the biome name and category, not a
        // Holder<Biome>. These category fallbacks preserve vanilla tag families.
        String tag = biomeTag.location().getPath();
        return switch (tag) {
            case "has_cindervane" -> category == Biome.BiomeCategory.EXTREME_HILLS
                    || category == Biome.BiomeCategory.MESA;
            case "has_atroxiia" -> category == Biome.BiomeCategory.ICY;
            case "has_raevyx" -> category == Biome.BiomeCategory.EXTREME_HILLS
                    || category == Biome.BiomeCategory.ICY || category == Biome.BiomeCategory.SAVANNA;
            case "has_stegonaut", "has_mossback" -> category == Biome.BiomeCategory.JUNGLE;
            case "has_moop" -> category == Biome.BiomeCategory.RIVER
                    || category == Biome.BiomeCategory.OCEAN || category == Biome.BiomeCategory.SWAMP;
            case "has_volitans_fallback" -> category == Biome.BiomeCategory.BEACH
                    || category == Biome.BiomeCategory.SWAMP || category == Biome.BiomeCategory.PLAINS;
            case "has_nulljaw" -> category == Biome.BiomeCategory.THEEND;
            default -> false;
        };
    }

    private static Map<ResourceLocation, Set<ResourceLocation>> loadDirectBiomeTags() {
        Map<ResourceLocation, Set<ResourceLocation>> tags = new HashMap<>();
        String[] tagNames = {
                "has_raevyx", "has_stegonaut", "has_cindervane", "has_atroxiia",
                "has_volitans", "has_volitans_fallback", "has_nulljaw", "has_moop",
                "has_mossback"
        };

        for (String tagName : tagNames) {
            ResourceLocation tagId = SaintsDragonsCommon.rl(tagName);
            Set<ResourceLocation> entries = new HashSet<>();
            try (InputStream stream = ForgeBiomeLoadingHandler.class.getClassLoader()
                    .getResourceAsStream(TAG_RESOURCE_ROOT + tagName + ".json")) {
                if (stream == null) {
                    SaintsDragonsCommon.LOGGER.warn("Missing biome tag resource for {}", tagId);
                    tags.put(tagId, entries);
                    continue;
                }
                JsonObject json = JsonParser.parseReader(new InputStreamReader(stream, StandardCharsets.UTF_8))
                        .getAsJsonObject();
                JsonArray values = json.getAsJsonArray("values");
                if (values != null) {
                    for (JsonElement value : values) {
                        String id = value.isJsonPrimitive()
                                ? value.getAsString()
                                : value.getAsJsonObject().get("id").getAsString();
                        if (!id.startsWith("#")) {
                            entries.add(new ResourceLocation(id));
                        }
                    }
                }
            } catch (Exception exception) {
                SaintsDragonsCommon.LOGGER.warn("Failed to read biome tag {}", tagId, exception);
            }
            tags.put(tagId, entries);
        }
        return Map.copyOf(tags);
    }
}
