package com.watershark9.dsjarmory.blocks;

import com.watershark9.dsjarmory.Main;
import com.watershark9.dsjarmory.init.ModBlocks;
import com.watershark9.dsjarmory.init.ModItems;
import com.watershark9.dsjarmory.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class StandardCubeBlock extends Block implements IHasModel{
	public StandardCubeBlock(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add( new ItemBlock(this).setRegistryName( this.getRegistryName() ) );
		
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer( Item.getItemFromBlock(this), 0, "inventory" );
	}

}
