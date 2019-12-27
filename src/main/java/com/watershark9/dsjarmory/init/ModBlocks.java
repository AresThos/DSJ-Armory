package com.watershark9.dsjarmory.init;

import java.util.ArrayList;
import java.util.List;

import com.watershark9.dsjarmory.blocks.BlockBase;
import com.watershark9.dsjarmory.blocks.OrichalcumBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ORICHALCUM_BLOCK = new OrichalcumBlock("orichalcum_block", Material.ROCK);
}
