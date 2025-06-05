package io.github.trashoflevillage.lubedrails.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;
import io.github.trashoflevillage.lubedrails.LubedRails;
import io.github.trashoflevillage.lubedrails.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PoweredRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractMinecart.class)
public abstract class AbstractMinecartEntityMixin extends VehicleEntity {
    @Unique
    private final double LUBED_RAIL_SPEED_MULT = 3;
    @Unique
    private static final TagKey<Block> lubricatedRailsTagKey = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(LubedRails.MODID, "lubricated_rails")
    );

    public AbstractMinecartEntityMixin(EntityType<?> entityType, Level world) {
        super(entityType, world);
    }

    @ModifyReturnValue(method = "getMaxSpeedWithRail", at = @At("TAIL"))
    private double getMaxSpeed(double value) {
        BlockState blockState = this.level().getBlockState(this.blockPosition());
        if (blockState.is(lubricatedRailsTagKey))
        {
            value *= LUBED_RAIL_SPEED_MULT;
        }
        return value;
    }

    @Inject(method = "moveAlongTrack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/AbstractMinecart;getDeltaMovement()Lnet/minecraft/world/phys/Vec3;"))
    private void applyCustomPoweredRailLogic(BlockPos pos, BlockState state, CallbackInfo ci, @Local(ordinal = 0) LocalBooleanRef bl, @Local(ordinal = 1) LocalBooleanRef bl2) {
        if (state.is(ModBlocks.LUBED_POWERED_RAIL)) {
            bl.set(state.getValue(PoweredRailBlock.POWERED));
            bl2.set(!bl.get());
        }
    }

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/AbstractMinecart;moveAlongTrack(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V"))
    private void applyCustomActivatorRailLogic(CallbackInfo ci) {
        BlockPos blockPos = this.blockPosition();
        BlockState blockState = this.level().getBlockState(blockPos);
        if (blockState.is(ModBlocks.LUBED_ACTIVATOR_RAIL)) {
            int i = blockPos.getX();
            int j = blockPos.getY();
            int k = blockPos.getZ();
            ((AbstractMinecart) (Object) this).activateMinecart(i, j, k, blockState.getValue(PoweredRailBlock.POWERED));
        }
    }
}
