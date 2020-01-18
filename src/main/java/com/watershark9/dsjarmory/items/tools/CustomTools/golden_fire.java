package com.watershark9.dsjarmory.items.tools.CustomTools;

import java.util.Collection;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import com.google.common.collect.Multimap;
import com.watershark9.dsjarmory.Main;
import com.watershark9.dsjarmory.init.ModItems;
import com.watershark9.dsjarmory.util.IHasModel;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;



public class golden_fire extends ItemSword implements IHasModel {
	
	// Global Variables
	private double attack, speed, mini,maxi; // Default attack is 1; Default speed is 4
	
	// Constructor
	
	private double randomNumber(double rangeMin, double rangeMax) {
		Random r = new Random();
		return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
	}

	public golden_fire(String name, ToolMaterial material, double min, double max, double sp) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModItems.DSJ_TAB);
		
		ModItems.ITEMS.add(this);
		mini=min;
		maxi=max;
		attack = randomNumber(mini,maxi);
		speed = sp;
	}
	
	// Custom Stuff
	
	private boolean isDualWielding(EntityLivingBase play) {
		if ( play.getHeldItemOffhand().getItem() == play.getHeldItemMainhand().getItem() ) { 
			return true;
		}
		else {
			return false;
		}
	}
	
	private void buff(EntityLivingBase play, int duration, int boost) {
		if ( isDualWielding(play) ) {
			//duration = 1600; boost = 3;
			
			play.addPotionEffect(new PotionEffect(MobEffects.SPEED, duration, boost));
			play.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, duration, boost));
			play.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, duration, boost));
			
			play.swingArm( play.getActiveHand().OFF_HAND );
		}
	}
	private void fireAttack(EntityLivingBase target, int secondsOnFire) {
		target.setFire(secondsOnFire);
		
		}
	
	private void removebuff(EntityLivingBase play) {
		play.removePotionEffect(MobEffects.SPEED);
		play.removePotionEffect(MobEffects.FIRE_RESISTANCE);
		play.removePotionEffect(MobEffects.RESISTANCE);
	}
	
	private boolean isBuffActive(EntityLivingBase entity) {
		
		if( entity.getActivePotionEffect( MobEffects.FIRE_RESISTANCE ) == null ) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	// Custom Calls
	
	/*
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		// TODO Auto-generated method stub
		EntityPlayer player = Minecraft.getMinecraft().player;
		if(isDualWielding( player ) && !isBuffActive( player ) ) {
			buff(player,1600,3);
		}
		else {
			removebuff(player);
		}
		
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	} */
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		attack = randomNumber(mini,maxi);
		fireAttack( target,2 );
		buff(attacker,1600,3);
		
		return super.hitEntity(stack, target, attacker);
	}
	
	
	
	// ItemTool stuff
	
	@Override
	public boolean isEnchantable(ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
	//
	
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		final Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);

		if (slot == EntityEquipmentSlot.MAINHAND) {
			replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER, attack);
			replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_MODIFIER, speed);
		}

		return modifiers;
	}

	/**
	 * Replace a modifier in the {@link Multimap} with a copy that's had {@code multiplier} applied to its value.
	 *
	 * @param modifierMultimap The MultiMap
	 * @param attribute        The attribute being modified
	 * @param id               The ID of the modifier
	 * @param multiplier       The multiplier to apply
	 */
	private void replaceModifier(Multimap<String, AttributeModifier> modifierMultimap, IAttribute attribute, UUID id, double multiplier) {
		// Get the modifiers for the specified attribute
		final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute.getName());

		// Find the modifier with the specified ID, if any
		final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getID().equals(id)).findFirst();

		if (modifierOptional.isPresent()) { // If it exists,
			final AttributeModifier modifier = modifierOptional.get();
			modifiers.remove(modifier); // Remove it
			modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), modifier.getAmount() * multiplier, modifier.getOperation())); // Add the new modifier
		}
	}
	
}
