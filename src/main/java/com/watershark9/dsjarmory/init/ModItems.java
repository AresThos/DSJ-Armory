package com.watershark9.dsjarmory.init;

import java.util.ArrayList;
import java.util.List;

import com.watershark9.dsjarmory.items.ItemBase;
import com.watershark9.dsjarmory.items.armor.ArmorBase;
import com.watershark9.dsjarmory.items.tabs.DSJArmoryCreativeTab;
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
import com.watershark9.dsjarmory.items.tools.CustomTools.breadshot;
import com.watershark9.dsjarmory.items.tools.CustomTools.golden_fire;
import com.watershark9.dsjarmory.items.tools.CustomTools.melodias;
import com.watershark9.dsjarmory.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	public static final CreativeTabs DSJ_TAB = new DSJArmoryCreativeTab("dsj_armory");

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
	
	private static double damageFormula(double y) { return (y-1)/7; }
	private static double speedFormula(double x) { return -((x-4)/2.4); }
	
	//Exotic:
	
	//DSJ
	public static final ItemSword TIDAL_RIFT = new TidalRift("tidal_rift", MATERIAL_ORICHALCUM, damageFormula(13), speedFormula(9) ); // attack 13, speed 9
	public static final ItemSword XENTAR = new Xentar("xentar", MATERIAL_ORICHALCUM, damageFormula(40), speedFormula(0.4) ); // attack 40, speed 0.4
	public static final ItemSword DEMON_BLADE = new JanembaSword("demon_blade", MATERIAL_ORICHALCUM, damageFormula(20), speedFormula(1.6)); // attack 20, speed 1.6
	public static final ItemSword LION_EDGE = new LionEdge("lion_edge", MATERIAL_ORICHALCUM, damageFormula(10), speedFormula(1)); // attack 10, speed 1 (attack also is damage for arrow)
	public static final ItemSword GOLDEN_FIRE = new golden_fire("golden_fire", MATERIAL_ORICHALCUM, damageFormula(1), damageFormula(8), speedFormula(3.2) ); // attack random between 1 and 8, speed 3.2
	public static final ItemSword CHAOS_BEGINS = new ChaosBegins("chaos_begins", MATERIAL_ORICHALCUM, damageFormula(3), speedFormula(1.6)); // attack 3, speed 1.6
	public static final ItemSword BANEOFSEUX = new bane_of_seux("baneofseux", MATERIAL_ORICHALCUM, damageFormula(5), speedFormula(1.6) ); // attack 5, speed 1.6
	public static final ItemSword BREAD_SHOTGUN = new breadshot("baguette_shotgun", MATERIAL_ORICHALCUM, damageFormula(1), 7, speedFormula(1.6/2)); // attack 5, speed 1.6
	
	//Extras
	public static final ItemSword MELODIAS_RAPIER = new melodias("melodias_rapier", ToolMaterial.DIAMOND, damageFormula(5), speedFormula(2) ); // attack 5, speed 2
	public static final ItemSword PALADUS = new CustomSword("paladun_sword", ToolMaterial.GOLD, damageFormula(7), speedFormula(1)); // attack 7, speed 1
	public static final ItemSword ANGELUS_FERRUM = new CustomSword("angelus_ferrum", MATERIAL_ORICHALCUM, damageFormula(17), speedFormula(1.5) ); // attack 17, speed 1.7
	//Equipment:
	public static final ItemShield ADAMANT_SHIELD = new ada_shield("adamant_shield");
	
	// Armors: // name, textureName, Durability, ReductionAmounts, Enchantability, Sound, Toughness
	
	//Chronicle
	public static final ArmorMaterial ARMOR_CHRONICLE = EnumHelper.addArmorMaterial("armor_chronicle", Reference.MOD_ID +":chronicle", 40, new int[] {5,10,8,5}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F);
	public static final Item CHRONICLE_HELMET = new ArmorBase("chronicle_sallet", ARMOR_CHRONICLE, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHRONICLE_CHESTPLATE = new ArmorBase("chronicle_chestplate", ARMOR_CHRONICLE, 1, EntityEquipmentSlot.CHEST);
	public static final Item CHRONICLE_LEGGINGS = new ArmorBase("chronicle_leggins", ARMOR_CHRONICLE, 2, EntityEquipmentSlot.LEGS);
	public static final Item CHRONICLE_BOOTS = new ArmorBase("chronicle_boots", ARMOR_CHRONICLE, 1, EntityEquipmentSlot.FEET);
	
	
	//Items:
	public static final Item ORICHALCUM_INGOT = new ItemBase("orichalcum_ingot");
	public static final Item ORICHALCUM_CRYSTAL = new ItemBase("orichalcum_crystal");	
	
	public static final Item BULLET = new ItemBase("bullet");
	
	
}
