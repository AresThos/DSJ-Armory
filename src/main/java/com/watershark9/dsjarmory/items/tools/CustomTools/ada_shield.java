package com.watershark9.dsjarmory.items.tools.CustomTools;

import com.watershark9.dsjarmory.Main;
import com.watershark9.dsjarmory.init.ModItems;
import com.watershark9.dsjarmory.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ada_shield extends ItemShield implements IHasModel {

	public ada_shield(String name) {
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModItems.DSJ_TAB);;
		
		ModItems.ITEMS.add(this);
		
	}
	
	
	
	private void giveEffect(EntityLivingBase player) {
		int duration = 2400;
		player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, duration/2, 1) );
		player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, duration, 1) );
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		giveEffect(playerIn);
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
}
