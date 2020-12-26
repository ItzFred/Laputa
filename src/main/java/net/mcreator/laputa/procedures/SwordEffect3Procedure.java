package net.mcreator.laputa.procedures;

@LaputaModElements.ModElement.Tag
public class SwordEffect3Procedure extends LaputaModElements.ModElement {

	public SwordEffect3Procedure(LaputaModElements instance) {
		super(instance, 155);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SwordEffect3!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 180, (int) 1, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 180, (int) 1, (false), (false)));

	}

}
