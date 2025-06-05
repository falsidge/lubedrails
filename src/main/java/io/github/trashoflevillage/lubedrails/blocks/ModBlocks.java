package io.github.trashoflevillage.lubedrails.blocks;

import io.github.trashoflevillage.lubedrails.LubedRails;
import io.github.trashoflevillage.lubedrails.blocks.custom.LubricatedRailBlock;
import io.github.trashoflevillage.lubedrails.items.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DetectorRailBlock;
import net.minecraft.world.level.block.PoweredRailBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(LubedRails.MODID);

    public static final DeferredBlock<Block> LUBED_RAIL = registerBlock("lubricated_rail", ()->new LubricatedRailBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RAIL)));
    public static final DeferredBlock<Block> LUBED_POWERED_RAIL = registerBlock("lubricated_powered_rail",()->new PoweredRailBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POWERED_RAIL), true));
    public static final DeferredBlock<Block> LUBED_DETECTOR_RAIL = registerBlock("lubricated_detector_rail", ()->new DetectorRailBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DETECTOR_RAIL)));
    public static final DeferredBlock<Block> LUBED_ACTIVATOR_RAIL = registerBlock("lubricated_activator_rail", ()->new PoweredRailBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACTIVATOR_RAIL)));

    public static void registerModBlocks(IEventBus modEventBus) {
        LubedRails.LOGGER.info("Registering blocks for " + LubedRails.MODID);
        BLOCKS.register(modEventBus);
    }

    public static DeferredBlock<Block>  registerBlock(String name, Supplier<Block> block)
    {
        DeferredBlock<Block> deferredBlock = BLOCKS.register(name, block);
        ModItems.registerItem(deferredBlock);
        return deferredBlock;
    }
}

