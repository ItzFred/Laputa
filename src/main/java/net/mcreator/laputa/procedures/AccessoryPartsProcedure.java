package net.mcreator.laputa.procedures;

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

		entity.getPersistentData().putString("Accessory1", "");
		entity.getPersistentData().putString("Accessory2", "");
		entity.getPersistentData().putString("Accessory3", "");
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
						.getItem() == new ItemStack(NightVisionGogglesItem.block, (int) (1)).getItem())
				|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory2)
								.getItem() == new ItemStack(NightVisionGogglesItem.block, (int) (1)).getItem()))
				|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory3)
								.getItem() == new ItemStack(NightVisionGogglesItem.block, (int) (1)).getItem()))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 1, (int) 0, (false), (false)));
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
		if ((((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory1).getItem() == new ItemStack(PanicSystemItem.block, (int) (1)).getItem())
				|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory2)
								.getItem() == new ItemStack(PanicSystemItem.block, (int) (1)).getItem()))
				|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory3)
								.getItem() == new ItemStack(PanicSystemItem.block, (int) (1)).getItem()))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 4)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1, (int) 2, (true), (false)));
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 8)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1, (int) 1, (true), (false)));
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 12)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1, (int) 0, (false), (false)));
			}
		}
		if ((((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory1).getItem() == new ItemStack(BootRocketItem.block, (int) (1)).getItem())
				|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory2)
								.getItem() == new ItemStack(BootRocketItem.block, (int) (1)).getItem()))
				|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory3)
								.getItem() == new ItemStack(BootRocketItem.block, (int) (1)).getItem()))) {
			if ((((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new LaputaModVariables.PlayerVariables())).Accessory1)
							.getItem() == new ItemStack(PanicSystemItem.block, (int) (1)).getItem())
					|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new LaputaModVariables.PlayerVariables())).Accessory2)
									.getItem() == new ItemStack(PanicSystemItem.block, (int) (1)).getItem()))
					|| (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new LaputaModVariables.PlayerVariables())).Accessory3)
									.getItem() == new ItemStack(PanicSystemItem.block, (int) (1)).getItem()))) {
				if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 4)) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1, (int) 3, (true), (false)));
				} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 8)) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1, (int) 2, (true), (false)));
				} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < 12)) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1, (int) 1, (false), (false)));
				} else {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1, (int) 0, (false), (false)));
				}
			} else {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1, (int) 0, (false), (false)));
			}
		}
		if ((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory1)
						.getItem() == new ItemStack(ExplosiveAttachmentItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putString("Accessory1", "Explode");
		} else if ((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory2)
						.getItem() == new ItemStack(ExplosiveAttachmentItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putString("Accessory2", "Explode");
		} else if ((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory3)
						.getItem() == new ItemStack(ExplosiveAttachmentItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putString("Accessory3", "Explode");
		}
		if ((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory1)
						.getItem() == new ItemStack(FrozenGauntletItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putString("Accessory1", "Slow");
		} else if ((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory2)
						.getItem() == new ItemStack(FrozenGauntletItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putString("Accessory2", "Slow");
		} else if ((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory3)
						.getItem() == new ItemStack(FrozenGauntletItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putString("Accessory3", "Slow");
		}
		if ((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory1)
						.getItem() == new ItemStack(PoisonGauntletItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putString("Accessory1", "Poison");
		} else if ((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory2)
						.getItem() == new ItemStack(PoisonGauntletItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putString("Accessory2", "Poison");
		} else if ((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory3)
						.getItem() == new ItemStack(PoisonGauntletItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putString("Accessory3", "Poison");
		}
		if ((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory1)
						.getItem() == new ItemStack(FireyGauntletItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putString("Accessory1", "Fire");
		} else if ((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory2)
						.getItem() == new ItemStack(FireyGauntletItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putString("Accessory2", "Fire");
		} else if ((((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new LaputaModVariables.PlayerVariables())).Accessory3)
						.getItem() == new ItemStack(FireyGauntletItem.block, (int) (1)).getItem())) {
			entity.getPersistentData().putString("Accessory3", "Fire");
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
