package io.github.trashoflevillage.lubedrails.items;

import io.github.trashoflevillage.lubedrails.LubedRails;
import io.github.trashoflevillage.lubedrails.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LubedRails.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LubedRails.LOGGER.info("Registering items for " + LubedRails.MOD_ID + ".");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
            content.add(ModBlocks.LUBED_RAIL);
            content.add(ModBlocks.LUBED_POWERED_RAIL);
            content.add(ModBlocks.LUBED_DETECTOR_RAIL);
            content.add(ModBlocks.LUBED_ACTIVATOR_RAIL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(ModBlocks.LUBED_RAIL);
            content.add(ModBlocks.LUBED_POWERED_RAIL);
            content.add(ModBlocks.LUBED_DETECTOR_RAIL);
            content.add(ModBlocks.LUBED_ACTIVATOR_RAIL);
        });
    }
}
