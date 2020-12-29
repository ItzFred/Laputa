package net.mcreator.laputa.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.laputa.LaputaModElements;

import java.util.Map;
import java.util.HashMap;

@LaputaModElements.ModElement.Tag
public class EnemyHitAccessoryProcedure extends LaputaModElements.ModElement {
	public EnemyHitAccessoryProcedure(LaputaModElements instance) {
		super(instance, 190);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EnemyHitAccessory!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				System.err.println("Failed to load dependency sourceentity for procedure EnemyHitAccessory!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (((((sourceentity.getPersistentData().getString("Accessory1"))).equals("Fire"))
				|| ((((sourceentity.getPersistentData().getString("Accessory2"))).equals("Fire"))
						|| (((sourceentity.getPersistentData().getString("Accessory3"))).equals("Fire"))))) {
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == (ItemStack.EMPTY).getItem())) {
				entity.setFire((int) 4);
			}
		}
		if (((((sourceentity.getPersistentData().getString("Accessory1"))).equals("Slow"))
				|| ((((sourceentity.getPersistentData().getString("Accessory2"))).equals("Slow"))
						|| (((sourceentity.getPersistentData().getString("Accessory3"))).equals("Slow"))))) {
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == (ItemStack.EMPTY).getItem())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 80, (int) 0, (false), (false)));
			}
		}
		if (((((sourceentity.getPersistentData().getString("Accessory1"))).equals("Poison"))
				|| ((((sourceentity.getPersistentData().getString("Accessory2"))).equals("Poison"))
						|| (((sourceentity.getPersistentData().getString("Accessory3"))).equals("Poison"))))) {
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == (ItemStack.EMPTY).getItem())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 80, (int) 1, (false), (true)));
			}
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			Entity imediatesourceentity = event.getSource().getImmediateSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("imediatesourceentity", imediatesourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
