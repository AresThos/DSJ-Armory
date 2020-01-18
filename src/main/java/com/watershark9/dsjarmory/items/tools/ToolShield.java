package com.watershark9.dsjarmory.items.tools;

import com.watershark9.dsjarmory.Main;
import com.watershark9.dsjarmory.init.ModItems;
import com.watershark9.dsjarmory.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemShield;

public class ToolShield extends ItemShield implements IHasModel {

	public ToolShield(String name) {
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModItems.DSJ_TAB);
		
		ModItems.ITEMS.add(this);
		
	}
	
	
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
}
