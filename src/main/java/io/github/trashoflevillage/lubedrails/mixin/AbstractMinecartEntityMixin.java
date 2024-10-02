package io.github.trashoflevillage.lubedrails.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import io.github.trashoflevillage.lubedrails.blocks.ModBlocks;
import io.github.trashoflevillage.lubedrails.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PoweredRailBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.entity.vehicle.VehicleEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractMinecartEntity.class)
public abstract class AbstractMinecartEntityMixin extends VehicleEntity {
    private final double LUBED_RAIL_SPEED_MULT = 3;

    public AbstractMinecartEntityMixin(EntityType<?> entityType, World world) {
        super(entityType, world);
    }

    @ModifyReturnValue(method = "getMaxSpeed", at = @At("TAIL"))
    private double getMaxSpeed(double value) {
        BlockState blockState = this.getWorld().getBlockState(this.getBlockPos());
        if (blockState.isIn(ModTags.Blocks.LUBRICATED_RAILS)) value *= LUBED_RAIL_SPEED_MULT;
        return value;
    }

    @Inject(method = "moveOnRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/vehicle/AbstractMinecartEntity;getVelocity()Lnet/minecraft/util/math/Vec3d;"))
    private void applyCustomPoweredRailLogic(BlockPos pos, BlockState state, CallbackInfo ci, @Local(ordinal = 0) LocalBooleanRef bl, @Local(ordinal = 1) LocalBooleanRef bl2) {
        if (state.isOf(ModBlocks.LUBED_POWERED_RAIL)) {
            bl.set(state.get(PoweredRailBlock.POWERED));
            bl2.set(!bl.get());
        }
    }

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/vehicle/AbstractMinecartEntity;moveOnRail(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V"))
    private void applyCustomActivatorRailLogic(CallbackInfo ci) {
        BlockPos blockPos = this.getBlockPos();
        BlockState blockState = this.getWorld().getBlockState(blockPos);
        if (blockState.isOf(ModBlocks.LUBED_ACTIVATOR_RAIL)) {
            int i = blockPos.getX();
            int j = blockPos.getY();
            int k = blockPos.getZ();
            this.onActivatorRail(i, j, k, (Boolean)blockState.get(PoweredRailBlock.POWERED));
        }
    }


    @Shadow private void onActivatorRail(int x, int y, int z, boolean powered) {}
}
