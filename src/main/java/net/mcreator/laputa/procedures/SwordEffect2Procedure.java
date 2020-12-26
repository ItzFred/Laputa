package net.mcreator.laputa.procedures;

@LaputaModElements.ModElement.Tag
public class SwordEffect2Procedure extends LaputaModElements.ModElement {

	public SwordEffect2Procedure(LaputaModElements instance) {
		super(instance, 154);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SwordEffect2!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 100, (int) 1, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 100, (int) 1, (false), (false)));

	}

}
