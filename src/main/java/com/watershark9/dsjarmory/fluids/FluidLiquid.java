package com.watershark9.dsjarmory.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidLiquid extends Fluid {

	public FluidLiquid(String fluidName, ResourceLocation still, ResourceLocation flowing) {
		super(fluidName, still, flowing);
		setUnlocalizedName(fluidName);
	}
	
	

}
