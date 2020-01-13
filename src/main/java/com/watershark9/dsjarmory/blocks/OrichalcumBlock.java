package com.watershark9.dsjarmory.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class OrichalcumBlock extends StandardCubeBlock{

	public OrichalcumBlock(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(5.0F); // How long does it take to break // https://minecraftmodcustomstuff.fandom.com/wiki/Hardness
		setResistance(30.0F); // Resitance against explosives // https://minecraft.gamepedia.com/Explosion
		setHarvestLevel("pickaxe",2); // ( Tool used to break; Mining Level (Stone,Diamond,etc) ) // https://minecraftmodcustomstuff.fandom.com/wiki/HarvestLevel
		//setLightLevel(0); // How much Light does block emmit // https://minecraft.gamepedia.com/Light
		//setLightOpacity(0); // How much light can pass thru object
		//setBlockUnbreakable();
	}

}
