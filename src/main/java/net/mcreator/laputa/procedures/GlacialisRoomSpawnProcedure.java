package net.mcreator.laputa.procedures;

@LaputaModElements.ModElement.Tag
public class GlacialisRoomSpawnProcedure extends LaputaModElements.ModElement {

	public GlacialisRoomSpawnProcedure(LaputaModElements instance) {
		super(instance, 137);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure GlacialisRoomSpawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure GlacialisRoomSpawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure GlacialisRoomSpawn!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure GlacialisRoomSpawn!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		double RoomSpawnNumber = 0;
		RoomSpawnNumber = (double) ((new Random()).nextInt((int) 5 + 1));
		if (((RoomSpawnNumber) == 0)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("laputa", "glacialisplainroom"));

				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) x, (int) (y - 13), (int) z),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		} else if (((RoomSpawnNumber) == 1)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("laputa", "glacialisplainroom2"));

				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) x, (int) (y - 13), (int) z),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		} else if (((RoomSpawnNumber) == 2)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("laputa", "yateveoplanetroom"));

				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) x, (int) (y - 1), (int) z),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		} else if (((RoomSpawnNumber) == 3)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("laputa", "yateveocoilroom2"));

				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) x, (int) (y - 1), (int) z),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		} else if (((RoomSpawnNumber) == 4)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("laputa", "laputawellroom"));

				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) x, (int) (y - 1), (int) z),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		} else if (((RoomSpawnNumber) == 5)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("laputa", "yateveocanopy"));

				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) x, (int) (y - 1), (int) z),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		}

	}

}
