package net.heispeg.daiyousei.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.heispeg.daiyousei.Daiyousei;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item ICE_DUST = registerItem("ice_dust",
            new Item(new FabricItemSettings().group(ModItemGroup.DAIYOUSEI)));
    public static final Item MELTED_ICE_DUST = registerItem("melted_ice_dust",
            new Item(new FabricItemSettings().group(ModItemGroup.DAIYOUSEI)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Daiyousei.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Daiyousei.LOGGER.debug("Registering items for " + Daiyousei.MOD_ID);

    }
        }