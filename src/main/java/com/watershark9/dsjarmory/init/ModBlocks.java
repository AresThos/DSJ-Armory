package com.watershark9.dsjarmory.init;

import java.util.ArrayList;
import java.util.List;

import com.watershark9.dsjarmory.blocks.BlockBase;
import com.watershark9.dsjarmory.blocks.OrichalcumBlock;
import com.watershark9.dsjarmory.blocks.OrichalcumOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ORICHALCUM_BLOCK = new OrichalcumBlock("orichalcum_block", Material.IRON);
	public static final Block ORICHALCUM_ORE = new OrichalcumOre("orichalcum_ore", Material.ROCK);
	
	//Utility Blocks
	public static final Block GLASS_FURNACE = new BlockBase("glass_furnace", Material.ROCK);
	public static final Block EXOTIC_WORKBENCH = new BlockBase("exotic_workbench", Material.WOOD);
	
}
