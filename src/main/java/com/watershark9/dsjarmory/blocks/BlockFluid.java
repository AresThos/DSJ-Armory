package com.watershark9.dsjarmory.blocks;

import com.watershark9.dsjarmory.init.ModBlocks;
import com.watershark9.dsjarmory.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluid extends BlockFluidClassic {

	public BlockFluid(String name, Fluid fluid, Material materialIn) {
		super(fluid, materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add( new ItemBlock(this).setRegistryName( this.getRegistryName() ) );
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

}
