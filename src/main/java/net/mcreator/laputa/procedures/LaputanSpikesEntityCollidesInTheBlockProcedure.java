package net.mcreator.laputa.procedures;

@LaputaModElements.ModElement.Tag
public class LaputanSpikesEntityCollidesInTheBlockProcedure extends LaputaModElements.ModElement {

	public LaputanSpikesEntityCollidesInTheBlockProcedure(LaputaModElements instance) {
		super(instance, 87);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure LaputanSpikesEntityCollidesInTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		entity.attackEntityFrom(DamageSource.GENERIC, (float) 2);

	}

}
