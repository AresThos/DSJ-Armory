package com.watershark9.dsjarmory.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class MoltenMetal extends Fluid {
	
	int Density_of_Diamond = (3150+3530)/2;
	int Density_of_Steel = (7750+8060)/2; int Melting_Temp_Steel = (1698+1813+1783)/3;

	public MoltenMetal(String fluidName, ResourceLocation still, ResourceLocation flowing) {
		super(fluidName, still, flowing);
		setUnlocalizedName(fluidName);
		
		this.setLuminosity(15);
		this.setDensity(Density_of_Steel);
		this.setViscosity(Density_of_Diamond);
		this.setTemperature(Density_of_Diamond);
	}
	
}
