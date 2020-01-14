package com.watershark9.dsjarmory.init;

import java.util.ArrayList;
import java.util.List;

import com.watershark9.dsjarmory.items.ItemBase;
import com.watershark9.dsjarmory.items.tools.CustomSword;
import com.watershark9.dsjarmory.items.tools.ToolAxe;
import com.watershark9.dsjarmory.items.tools.ToolHoe;
import com.watershark9.dsjarmory.items.tools.ToolPickaxe;
import com.watershark9.dsjarmory.items.tools.ToolShield;
import com.watershark9.dsjarmory.items.tools.ToolSpade;
import com.watershark9.dsjarmory.items.tools.ToolSword;
import com.watershark9.dsjarmory.items.tools.CustomTools.ChaosBegins;
import com.watershark9.dsjarmory.items.tools.CustomTools.JanembaSword;
import com.watershark9.dsjarmory.items.tools.CustomTools.LionEdge;
import com.watershark9.dsjarmory.items.tools.CustomTools.TidalRift;
import com.watershark9.dsjarmory.items.tools.CustomTools.Xentar;
import com.watershark9.dsjarmory.items.tools.CustomTools.ada_shield;
import com.watershark9.dsjarmory.items.tools.CustomTools.bane_of_seux;
import com.watershark9.dsjarmory.items.tools.CustomTools.golden_fire;
import com.watershark9.dsjarmory.items.tools.CustomTools.melodias;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials:
	public static final ToolMaterial MATERIAL_ORICHALCUM = EnumHelper.addToolMaterial("material_orichalcum", 4, 1561*2, 8*2, 4.0F, 10*2);
	
	//Tools:
	
	//Orichalcum
	public static final ItemSword ORICHALCUM_SWORD = new ToolSword("orichalcum_sword", MATERIAL_ORICHALCUM);
	public static final ItemHoe ORICHALCUM_HOE = new ToolHoe("orichalcum_hoe", MATERIAL_ORICHALCUM);
	public static final ItemAxe ORICHALCUM_AXE = new ToolAxe("orichalcum_axe", MATERIAL_ORICHALCUM);
	public static final ItemPickaxe ORICHALCUM_PICKAXE = new ToolPickaxe("orichalcum_pickaxe", MATERIAL_ORICHALCUM);
	public static final ItemSpade ORICHALCUM_SPADE = new ToolSpade("orichalcum_spade", MATERIAL_ORICHALCUM);
	
	/*
	 Custom Sword Damage Formula: f(x)=1+(7*x)
	 Custom Sword Speed Formula: f(x)=4+((2.4)*(-(x)))
	 
	 Example Template: 
	 public static final ItemSword NAME_IN_ALL_CAPS = new CustomSword("custom_sword", MATERIAL, damage_formula_result, speed_formula_result ); // attack intended, speed intended
	 */
	
	//Exotic:
	
	//DSJ
	public static final ItemSword TIDAL_RIFT = new TidalRift("tidal_rift", MATERIAL_ORICHALCUM, 1.142857, -1.7 ); // attack 9, speed 8
	public static final ItemSword XENTAR = new Xentar("xentar", MATERIAL_ORICHALCUM, 5.571429, 1.5 ); // attack 40, speed 0.4
	public static final ItemSword DEMON_BLADE = new JanembaSword("demon_blade", MATERIAL_ORICHALCUM, 2.714286, 1); // attack 20, speed 1.6
	public static final ItemSword LION_EDGE = new LionEdge("lion_edge", MATERIAL_ORICHALCUM, 1.285714, 1.25); // attack 10, speed 1 (attack also is damage for arrow)
	public static final ItemSword GOLDEN_FIRE = new golden_fire("golden_fire", MATERIAL_ORICHALCUM, 0, 1, 0.3 ); // attack random between 1 and 8, speed 3.2
	public static final ItemSword CHAOS_BEGINS = new ChaosBegins("chaos_begins", MATERIAL_ORICHALCUM, 0.285714, 1.3 ); // attack 3, speed 1.6
	public static final ItemSword BANEOFSEUX = new bane_of_seux("baneofseux", MATERIAL_ORICHALCUM, 0.571429, 1 ); // attack 5, speed 1.6
	
	//Extras
	public static final ItemSword MELODIAS_RAPIER = new melodias("melodias_rapier", ToolMaterial.DIAMOND, 0.571429, 0.79 ); // attack 5, speed 2
	public static final ItemSword PALADUS = new CustomSword("paladun_sword", ToolMaterial.GOLD, 0.857143, 1.25); // attack 7, speed 1
	public static final ItemSword ANGELUS_FERRUM = new CustomSword("angelus_ferrum", MATERIAL_ORICHALCUM, 2.285714, 0.958333 ); // attack 17, speed 1.7
	//Equipment:
	public static final ItemShield ADAMANT_SHIELD = new ada_shield("adamant_shield");
	
	//Items:
	public static final Item ORICHALCUM_INGOT = new ItemBase("orichalcum_ingot");
	public static final Item ORICHALCUM_CRYSTAL = new ItemBase("orichalcum_crystal");
	
	public static final Item BULLET = new ItemBase("bullet");
	
	
}
