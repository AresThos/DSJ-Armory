package com.watershark9.dsjarmory.items.tabs;
 
import com.watershark9.dsjarmory.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
public class DSJArmoryCreativeTab extends CreativeTabs {
	
	
    public DSJArmoryCreativeTab(String label) {
		super(label);
	}

	@SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.ORICHALCUM_CRYSTAL);
    }
 
}