package com.watershark9.dsjarmory.init;

import java.util.ArrayList;
import java.util.List;

import com.watershark9.dsjarmory.items.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	//public static final ToolMaterial MATERIAL_ORICHALCUM = EnumHelper.addToolMaterial("material_orichalcum", 3, maxUses, efficiency, damage, enchantability);
	
	//Weapons
	public static final Item TIDAL_RIFT = new ItemBase("tidal_rift");
	public static final Item XENTAR = new ItemBase("xentar");
	public static final Item DEMON_BLADE = new ItemBase("demon_blade");
	
	//Items
	public static final Item 	ORICHALCUM_INGOT = new ItemBase("orichalcum_ingot");
	
}
