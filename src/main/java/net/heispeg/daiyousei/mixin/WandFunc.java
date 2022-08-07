package net.heispeg.daiyousei.mixin;

import net.heispeg.daiyousei.Daiyousei;
import net.heispeg.daiyousei.item.ModItems;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.lang.reflect.Method;

@Mixin(AnimalEntity.class)
public abstract class WandFunc {
	@Inject(method = "interactMob", at = @At("HEAD"))
	public ActionResult activateWand(PlayerEntity player, Hand hand, CallbackInfoReturnable info) {
		AnimalEntity animal = (AnimalEntity) (Object) this;
		if (player.getStackInHand(hand).isOf(ModItems.THE_WAND_OF_LOVE)) {
			int i = animal.getBreedingAge();
			if (!animal.world.isClient && i == 0 && animal.canEat()) {
				animal.lovePlayer(player);
				return ActionResult.SUCCESS;
			}
		}
		return ActionResult.PASS;
	}
}

