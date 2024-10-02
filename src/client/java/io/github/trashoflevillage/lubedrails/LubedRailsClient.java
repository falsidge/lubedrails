package io.github.trashoflevillage.lubedrails;

import io.github.trashoflevillage.lubedrails.blocks.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.CowEntityModel;

public class LubedRailsClient implements ClientModInitializer {
	private static final Block[] blocksWithTransparency = new Block[] {
			ModBlocks.LUBED_RAIL, ModBlocks.LUBED_POWERED_RAIL, ModBlocks.LUBED_DETECTOR_RAIL, ModBlocks.LUBED_ACTIVATOR_RAIL
	};

	@Override
	public void onInitializeClient() {
		for (Block i : blocksWithTransparency)
			BlockRenderLayerMap.INSTANCE.putBlock(i, RenderLayer.getCutout());
	}
}