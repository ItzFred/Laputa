package net.mcreator.laputa.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.laputa.item.ShoeCushionsItem;
import net.mcreator.laputa.item.SharpeningStoneItem;
import net.mcreator.laputa.item.MetalProtectivePlateItem;
import net.mcreator.laputa.LaputaModVariables;
import net.mcreator.laputa.LaputaModElements;

import java.util.Map;
import java.util.HashMap;

@LaputaModElements.ModElement.Tag
public class AccessoryPartsProcedure extends LaputaModElements.ModElement {
	public AccessoryPartsProcedure(LaputaModElements instance) {
		super(instance, 178);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AccessoryParts!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory1)
						.getItem() == new ItemStack(MetalProtectivePlateItem.block, (int) (1)).getItem())
				|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory2)
								.getItem() == new ItemStack(MetalProtectivePlateItem.block, (int) (1)).getItem()))
				|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory3)
								.getItem() == new ItemStack(MetalProtectivePlateItem.block, (int) (1)).getItem()))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1, (int) 0, (false), (false)));
		}
		if ((((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory1)
						.getItem() == new ItemStack(SharpeningStoneItem.block, (int) (1)).getItem())
				|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory2)
								.getItem() == new ItemStack(SharpeningStoneItem.block, (int) (1)).getItem()))
				|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory3)
								.getItem() == new ItemStack(SharpeningStoneItem.block, (int) (1)).getItem()))) {
			if ((ItemTags.getCollection().getOrCreate(new ResourceLocation(("forge:melee_weapons").toLowerCase(java.util.Locale.ENGLISH)))
					.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 1, (int) 0, (false), (false)));
			}
		}
		if ((((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory1)
						.getItem() == new ItemStack(ShoeCushionsItem.block, (int) (1)).getItem())
				|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory2)
								.getItem() == new ItemStack(ShoeCushionsItem.block, (int) (1)).getItem()))
				|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory3)
								.getItem() == new ItemStack(ShoeCushionsItem.block, (int) (1)).getItem()))) {
			entity.fallDistance = (float) (0);
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
