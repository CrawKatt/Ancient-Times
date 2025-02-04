package com.delu.ancienttimes.datagen.client;

import com.delu.ancienttimes.AncientTimes;
import com.delu.ancienttimes.registries.ModBlocks;
import com.delu.ancienttimes.registries.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelsProvider extends ItemModelProvider {
    public final ModelFile generated = getExistingFile(mcLoc("item/generated"));
    public final ModelFile spawnEgg = getExistingFile(mcLoc("item/template_spawn_egg"));

    public final ModelFile rod = getExistingFile(mcLoc("item/handheld_rod"));
    public final ModelFile handheld = getExistingFile(mcLoc("item/handheld"));
    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AncientTimes.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simple(ModItems.MARD_FLOWER.get(), ModItems.MARD_BULB.get(), ModItems.RAVENHEAD_SEEDS.get(), ModItems.MAGNIFYING_GLASS.get(), ModItems.DIAMOND_CHISEL.get(), ModItems.RAVENHEADS_FRUIT.get(), ModItems.ROTTEN_RAVENHEADS_FRUIT.get(), ModItems.RAVENHEADS_THORNS.get());
        spawnEgg(ModItems.TRIOCLANTUS_SPAWN_EGG.get());
        spawnEgg(ModItems.SCALEMOUFLIS_SPAWN_EGG.get());
        spawnEgg(ModItems.RUMOROXL_SPAWN_EGG.get());
        //simple(ModBlocks.RAVENHEADS_THORNBUSH_BLOCK.get());
        simpleItem(ModItems.MEAL_SIGN);
        simpleItem(ModItems.MEAL_HANGING_SIGN);
        simpleItem(ModItems.MEAL_BOAT);
        simpleItem(ModItems.MEAL_CHEST_BOAT);
    }

    private void simple(Item... items) {
        for (Item item : items) {
            String name = ForgeRegistries.ITEMS.getKey(item).getPath();
            getBuilder(name).parent(generated).texture("layer0", "item/" + name);
        }
    }

    private void simple(ItemLike... items){
        for (ItemLike itemProvider : items){
            simple(itemProvider.asItem());
        }
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AncientTimes.MODID,"item/" + item.getId().getPath()));
    }
    private void spawnEgg(Item... items) {
        for (Item item : items) {
            String name = ForgeRegistries.ITEMS.getKey(item).getPath();
            getBuilder(name).parent(spawnEgg);
        }
    }

    private void rod(Item... items) {
        for (Item item : items) {
            String name = ForgeRegistries.ITEMS.getKey(item).getPath();
            getBuilder(name).parent(rod).texture("layer0", "item/" + name);
        }
    }

    protected void handheld(Item... items) {
        for (Item item : items) {
            String name = ForgeRegistries.ITEMS.getKey(item).getPath();
            getBuilder(name).parent(handheld).texture("layer0", "item/" + name);
        }
    }
}
