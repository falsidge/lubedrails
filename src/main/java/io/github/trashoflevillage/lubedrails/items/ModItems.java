package io.github.trashoflevillage.lubedrails.items;

import io.github.trashoflevillage.lubedrails.LubedRails;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LubedRails.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,LubedRails.MODID);

    public static List<DeferredItem<BlockItem>> RAIL_ITEMS = new ArrayList<>();

    public static void registerItem(DeferredBlock<Block> block)
    {

        RAIL_ITEMS.add(ITEMS.registerSimpleBlockItem(block));
    }

    public static void registerModItems(IEventBus modEventBus)
    {
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
    @EventBusSubscriber(modid = LubedRails.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class GameEvents
    {
        @SubscribeEvent
        private static void addCreative(BuildCreativeModeTabContentsEvent event)
        {
            if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS || event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
                for (var item : RAIL_ITEMS)
                {
                    event.accept(item);
                }
            }
        }
    }
}
