package com.watershark9.dsjarmory.init;

import java.util.ArrayList;
import java.util.List;

import com.watershark9.dsjarmory.blocks.StandardCubeBlock;
import com.watershark9.dsjarmory.blocks.BlockFluid;
import com.watershark9.dsjarmory.blocks.CustomShapeBlock;
import com.watershark9.dsjarmory.blocks.OrichalcumBlock;
import com.watershark9.dsjarmory.blocks.OrichalcumOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ORICHALCUM_BLOCK = new OrichalcumBlock("orichalcum_block", Material.IRON);
	public static final Block ORICHALCUM_ORE = new OrichalcumOre("orichalcum_ore", Material.ROCK);
	
	//Utility Blocks
	public static final Block GLASS_FURNACE = new StandardCubeBlock("glass_furnace", Material.ROCK);
	public static final Block EXOTIC_WORKBENCH = new CustomShapeBlock("exotic_workbench_table", Material.WOOD);
	
	//Fluids
	public static final Block MOLTEN_ORICHALCUM_BLOCK = new BlockFluid("molten_orichalcum", ModFluids.MOLTEN_ORICHALCUM, Material.LAVA);
	
}
