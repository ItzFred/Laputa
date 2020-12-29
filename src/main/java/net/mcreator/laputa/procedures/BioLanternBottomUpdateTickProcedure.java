package net.mcreator.laputa.procedures;

@LaputaModElements.ModElement.Tag
public class BioLanternBottomUpdateTickProcedure extends LaputaModElements.ModElement {

	public BioLanternBottomUpdateTickProcedure(LaputaModElements instance) {
		super(instance, 219);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BioLanternBottomUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BioLanternBottomUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BioLanternBottomUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BioLanternBottomUpdateTick!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BioLanterTopBlock.block.getDefaultState().getBlock())) {
			if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BioLanternBottomBlock.block.getDefaultState()
					.getBlock()))) {
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BioLanternBottomBlock.block.getDefaultState()
				.getBlock())) {
			if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BioLanterTopBlock.block.getDefaultState()
					.getBlock()))) {
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(BioLanternBottomBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			}
		}

	}

}
