package net.mcreator.laputa.procedures;

@LaputaModElements.ModElement.Tag
public class BioLanternBottomBlockIsPlacedByProcedure extends LaputaModElements.ModElement {

	public BioLanternBottomBlockIsPlacedByProcedure(LaputaModElements instance) {
		super(instance, 220);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BioLanternBottomBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BioLanternBottomBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BioLanternBottomBlockIsPlacedBy!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BioLanternBottomBlockIsPlacedBy!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock()))
				|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.STRUCTURE_VOID.getDefaultState()
						.getBlock())
						|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.WATER.getDefaultState()
								.getBlock())))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BioLanterTopBlock.block.getDefaultState(), 3);
		}

	}

}
