package io.github.trashoflevillage.lubedrails;

import com.mojang.logging.LogUtils;
import io.github.trashoflevillage.lubedrails.blocks.ModBlocks;
import io.github.trashoflevillage.lubedrails.items.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(LubedRails.MODID)
public class LubedRails
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "lubedrails";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public LubedRails(IEventBus modEventBus, ModContainer modContainer)
    {
        ModBlocks.registerModBlocks(modEventBus);
        ModItems.registerModItems(modEventBus);
    }
}
