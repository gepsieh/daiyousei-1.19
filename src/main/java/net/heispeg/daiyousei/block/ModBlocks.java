package net.heispeg.daiyousei.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.heispeg.daiyousei.Daiyousei;
import net.heispeg.daiyousei.block.custom.HuggerBlock;
import net.heispeg.daiyousei.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block DAILEMENT_ORE = registerBlock("dailement_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f)
                    .requiresTool(),UniformIntProvider.create(3,7)),ModItemGroup.DAIYOUSEI);
    public static final Block HUGGER_BLOCK = registerBlock("hugger_block",
            new HuggerBlock(FabricBlockSettings.of(Material.WOOL).strength(1.5f))
            ,ModItemGroup.DAIYOUSEI);

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(Daiyousei.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(Daiyousei.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks(){
        Daiyousei.LOGGER.debug("Registering blocks for " + Daiyousei.MOD_ID);
    }
}
