package com.watershark9.dsjarmory.items.tools.CustomTools;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import com.google.common.collect.Multimap;
import com.watershark9.dsjarmory.Main;
import com.watershark9.dsjarmory.init.ModItems;
import com.watershark9.dsjarmory.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class breadshot extends ItemSword implements IHasModel {
	
	double attack,speed;
	
	public breadshot(String name, ToolMaterial material, double at, double sp) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		
		ModItems.ITEMS.add(this);
		
		attack = at;
		speed = sp;
	}

	
	//
	
	private double randomNumber(double rangeMin, double rangeMax) {
		Random r = new Random();
		return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
	}
	
	private void shoot(World world, EntityPlayer play, double multiplyaim, double accelaim, int knockback, double unaccuracy) {
		
		Vec3d lookaim = play.getLookVec();
		EntityTippedArrow fireb = new EntityTippedArrow(world);

		fireb.setPosition( (play.posX + lookaim.x * multiplyaim), ( (play.posY + 1) + lookaim.y * multiplyaim), (play.posZ + lookaim.z * multiplyaim) );
		fireb.motionX = lookaim.x * accelaim + randomNumber( (unaccuracy * -1), unaccuracy);
		fireb.motionY = lookaim.y * accelaim + randomNumber( (unaccuracy * -1), unaccuracy);
		fireb.motionZ = lookaim.z * accelaim + randomNumber( (unaccuracy * -1), unaccuracy);
		
		fireb.setDamage(attack);
		fireb.setKnockbackStrength(knockback);
		world.spawnEntity(fireb);
		
	}
	
	private void shooting(World world, EntityPlayer play) {
		
		if ( play.getCooledAttackStrength(0) == 1 ) {
			shoot(world, play, 1.5D, randomNumber(0.75, 10), 4, 0.5);
			shoot(world, play, 1.5D, randomNumber(0.75, 10), 4, 0.5);
			play.resetCooldown();
		}
		
	}
	
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		shooting(worldIn, playerIn);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	//
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}
	
	//
	
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
