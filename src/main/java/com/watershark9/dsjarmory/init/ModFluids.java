package com.watershark9.dsjarmory.init;

import com.watershark9.dsjarmory.fluids.FluidLiquid;
import com.watershark9.dsjarmory.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {

	public static final Fluid MOLTEN_ORICHALCUM = new FluidLiquid("molten_orichalcum", new ResourceLocation( Reference.MOD_ID + ":blocks/molten_orichalcum_still"), new ResourceLocation( Reference.MOD_ID + ":blocks/molten_orichalcum_flow") );
	
	public static void registerFluids() {
		registerFluid(MOLTEN_ORICHALCUM);
	}
	
	public static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
}
