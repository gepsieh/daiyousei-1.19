package net.heispeg.daiyousei.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.heispeg.daiyousei.Daiyousei;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup DAIYOUSEI = FabricItemGroupBuilder.build(
            new Identifier(Daiyousei.MOD_ID, "daiyousei"), () -> new ItemStack(ModItems.ICE_DUST));
}
