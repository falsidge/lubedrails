package io.github.trashoflevillage.lubedrails.blocks;

import io.github.trashoflevillage.lubedrails.LubedRails;
import io.github.trashoflevillage.lubedrails.blocks.custom.LubricatedRailBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block LUBED_RAIL = registerBlock("lubricated_rail", new LubricatedRailBlock(AbstractBlock.Settings.copy(Blocks.RAIL)));
    public static final Block LUBED_POWERED_RAIL = registerBlock("lubricated_powered_rail", new PoweredRailBlock(AbstractBlock.Settings.copy(Blocks.POWERED_RAIL)));
    public static final Block LUBED_DETECTOR_RAIL = registerBlock("lubricated_detector_rail", new DetectorRailBlock(AbstractBlock.Settings.copy(Blocks.DETECTOR_RAIL)));
    public static final Block LUBED_ACTIVATOR_RAIL = registerBlock("lubricated_activator_rail", new PoweredRailBlock(AbstractBlock.Settings.copy(Blocks.ACTIVATOR_RAIL)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,
                Identifier.of(LubedRails.MOD_ID, name),
                block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(
                Registries.ITEM,
                Identifier.of(LubedRails.MOD_ID, name),
                new BlockItem(block,
                        new Item.Settings()));
    }

    public static void registerModBlocks() {
        LubedRails.LOGGER.info("Registering blocks for " + LubedRails.MOD_ID);
    }
}
