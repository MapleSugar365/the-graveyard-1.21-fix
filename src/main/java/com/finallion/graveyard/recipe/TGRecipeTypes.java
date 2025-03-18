package com.finallion.graveyard.recipe;

import com.finallion.graveyard.TheGraveyard;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TGRecipeTypes {

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, TheGraveyard.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, TheGraveyard.MOD_ID);

    public final static Supplier<RecipeType<OssuaryRecipe>> OSSUARY_CARVING = RECIPE_TYPES.register("ossuary_carving", () ->
            Type.INSTANCE
    );

    public final static Supplier<RecipeSerializer<OssuaryRecipe>> OSSUARY_CARVING_SERIALIZER = RECIPE_SERIALIZERS.register("ossuary_carving", () ->
            new CarvingRecipe.Serializer<>(OssuaryRecipe::new)
    );

    public static class Type implements RecipeType<OssuaryRecipe> {
        private Type() {
        }

        public static final Type INSTANCE = new Type();
        public static final ResourceLocation IDENTIFIER = ResourceLocation.parse("graveyard:ossuary_carving");
    }
}
