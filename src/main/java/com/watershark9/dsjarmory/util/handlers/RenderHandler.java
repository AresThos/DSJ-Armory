package com.watershark9.dsjarmory.util.handlers;

import com.watershark9.dsjarmory.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

	public static void registerCustomMeshesandStates() {
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.MOLTEN_ORICHALCUM_BLOCK), new ItemMeshDefinition() {
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation( "da:molten_orichalcum", "fluid" );
			}
		});
		ModelLoader.setCustomStateMapper(ModBlocks.MOLTEN_ORICHALCUM_BLOCK, new StateMapperBase() {
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("da:","fluid");
			}
		});
	}
}
