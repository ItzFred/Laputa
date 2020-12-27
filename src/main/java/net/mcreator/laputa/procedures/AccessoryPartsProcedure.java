package net.mcreator.laputa.procedures;

@LaputaModElements.ModElement.Tag
public class AccessoryPartsProcedure extends LaputaModElements.ModElement {

	public AccessoryPartsProcedure(LaputaModElements instance) {
		super(instance, 178);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AccessoryParts!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if ((((new ItemStack(, (int)(1)).getItem() == new ItemStack(MoonDustItem.block, (int)(1)).getItem())||(new ItemStack(, (int)(1)).getItem() == new ItemStack(MoonDustItem.block, (int)(1)).getItem()))||(new ItemStack(, (int)(1)).getItem() == new ItemStack(MoonDustItem.block, (int)(1)).getItem()))) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.SPEED,(int) 1,(int) 0, (false), (false)));}if ((((new ItemStack(, (int)(1)).getItem() == new ItemStack(LaputanDiamondItem.block, (int)(1)).getItem())||(new ItemStack(, (int)(1)).getItem() == new ItemStack(LaputanDiamondItem.block, (int)(1)).getItem()))||(new ItemStack(, (int)(1)).getItem() == new ItemStack(LaputanDiamondItem.block, (int)(1)).getItem()))) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST,(int) 1,(int) 0, (false), (false)));}

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
