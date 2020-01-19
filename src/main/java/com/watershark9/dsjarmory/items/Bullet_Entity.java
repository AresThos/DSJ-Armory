package com.watershark9.dsjarmory.items;

import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.world.World;

public class Bullet_Entity extends EntityTippedArrow {

	public Bullet_Entity(World worldIn, double damage) {
		super(worldIn);
		setDamage(damage);
		setKnockbackStrength(7);
		
	}
	
	

}
