package com.watershark9.dsjarmory.items.tools.CustomTools;

import java.util.Collection;
import java.util.Optional;
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



public class ChaosBegins extends ItemSword implements IHasModel {
	
	// Global Variables
	private double attack, speed; // Default attack is 1; Default speed is 4
	
	private void setAttack(double at) {
		attack = at; // f(x)=1+(9*x)
	}
	
	private void setSpeed(double sp) {
		speed = sp; // f(x)=4+(2.4*(-x))
	}
	
	// Constructor

	public ChaosBegins(String name, ToolMaterial material, double at, double sp) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		
		ModItems.ITEMS.add(this);
		
		
		setAttack(at);
		setSpeed(sp); 
	}
	
	// Custom Stuff
	
	
	
	// Custom Calls
	
	
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		
		int duration = 1600/2;
		
		//Hell
		target.addPotionEffect(new PotionEffect(MobEffects.POISON, duration, 3) );
		target.addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, duration, 1) );
		target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, duration, 5) );
		target.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, duration, 2) );
		target.addPotionEffect(new PotionEffect(MobEffects.HUNGER, duration, 5) );
		target.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, duration, 2) );
		target.addPotionEffect(new PotionEffect(MobEffects.WITHER, duration, 1) );
		//target.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, duration, 1) );
		target.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, duration, 1) );
		//Heaven
		target.addPotionEffect(new PotionEffect(MobEffects.LUCK, duration, 1) );
		target.addPotionEffect(new PotionEffect(MobEffects.HASTE, duration, 2) );
		
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
