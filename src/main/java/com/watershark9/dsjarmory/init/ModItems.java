package com.watershark9.dsjarmory.init;

import java.util.ArrayList;
import java.util.List;

import com.watershark9.dsjarmory.items.ItemBase;
import com.watershark9.dsjarmory.items.tools.CustomSword;
import com.watershark9.dsjarmory.items.tools.ToolSword;
import com.watershark9.dsjarmory.items.tools.CustomTools.JanembaSword;
import com.watershark9.dsjarmory.items.tools.CustomTools.LionEdge;
import com.watershark9.dsjarmory.items.tools.CustomTools.TidalRift;
import com.watershark9.dsjarmory.items.tools.CustomTools.Xentar;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial MATERIAL_ORICHALCUM = EnumHelper.addToolMaterial("material_orichalcum", 3, 1561, 8, 6, 10);
	
	//Weapons
	public static final ItemSword TIDAL_RIFT = new TidalRift("tidal_rift", MATERIAL_ORICHALCUM, 17/9, -4/2.4 ); // attack 18, speed 8
	public static final Item XENTAR = new Xentar("xentar", MATERIAL_ORICHALCUM, 13/3, 1.5 ); // attack 40, speed 0.4
	public static final Item DEMON_BLADE = new JanembaSword("demon_blade", MATERIAL_ORICHALCUM, 21.5/9, 1); // attack 22.5, speed 1.6
	public static final Item LION_EDGE = new LionEdge("lion_edge", MATERIAL_ORICHALCUM, 1, 1.25); // attack 10, speed 1
	
	//Items
	public static final Item ORICHALCUM_INGOT = new ItemBase("orichalcum_ingot");
	public static final Item ORICHALCUM_CRYSTAL = new ItemBase("orichalcum_crystal");
	
}
