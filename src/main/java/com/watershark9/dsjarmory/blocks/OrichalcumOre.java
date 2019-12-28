package com.watershark9.dsjarmory.blocks;

import java.util.Random;

import com.watershark9.dsjarmory.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class OrichalcumOre extends BlockBase{
	
	public OrichalcumOre(String name, Material material) {
		super(name,material);
		setSoundType(SoundType.STONE);
		setHardness(5);
		setResistance(15);
		setHarvestLevel("pickaxe",3);
	}
	
	@Override
	public Item getItemDropped( IBlockState state, Random rand, int fortune ) {
		return ModItems.ORICHALCUM_INGOT;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		
		int max = 3, min = 1;
		return rand.nextInt(max) + min;
		
	}

}
