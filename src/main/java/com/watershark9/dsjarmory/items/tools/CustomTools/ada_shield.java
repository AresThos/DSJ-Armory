package com.watershark9.dsjarmory.items.tools.CustomTools;

import com.watershark9.dsjarmory.Main;
import com.watershark9.dsjarmory.init.ModItems;
import com.watershark9.dsjarmory.util.IHasModel;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ada_shield extends ItemShield implements IHasModel {

	public ada_shield(String name) {
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModItems.DSJ_TAB);;
		
		ModItems.ITEMS.add(this);
		
	}
	
	
	
	private void giveEffect(EntityLivingBase player,int duration) {
		player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, duration, 3) );
	}
	
	/*
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		giveEffect(playerIn);
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}*/
	
	private boolean isOffHand(EntityLivingBase thing) {
		String offhand = thing.getHeldItemOffhand().getUnlocalizedName();
		String itemThing = this.getUnlocalizedName();
		if ( offhand.equals(itemThing) ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		if (isOffHand( (EntityLivingBase)entityIn )) {
			giveEffect( (EntityLivingBase)entityIn, 1);
		}
		
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	private int tickToSeconds(int seconds) {
		int tick = 20;
		return seconds * tick;
	}
	
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
}
