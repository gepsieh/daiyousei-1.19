package net.heispeg.daiyousei.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

public class HuggerBlock extends Block {

    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    public HuggerBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity livingEntity && !world.isClient){
            world.setBlockState(pos, state.cycle(ACTIVATED));
            livingEntity.clearStatusEffects();
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,100));
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}
