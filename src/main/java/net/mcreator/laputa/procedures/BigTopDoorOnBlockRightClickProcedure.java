package net.mcreator.laputa.procedures;

@LaputaModElements.ModElement.Tag
public class BigTopDoorOnBlockRightClickProcedure extends LaputaModElements.ModElement {

	public BigTopDoorOnBlockRightClickProcedure (LaputaModElements instance) {
		super(instance, 138);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("x") == null) {
			if(!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BigTopDoorOnBlockRightClick!");
			return;
		}
		if(dependencies.get("y") == null) {
			if(!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BigTopDoorOnBlockRightClick!");
			return;
		}
		if(dependencies.get("z") == null) {
			if(!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BigTopDoorOnBlockRightClick!");
			return;
		}
		if(dependencies.get("world") == null) {
			if(!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BigTopDoorOnBlockRightClick!");
			return;
		}

				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				IWorld world = (IWorld) dependencies.get("world");

		if (((new Object() {
	public Direction getDirection(BlockPos pos){
		try {
			BlockState _bs = world.getBlockState(pos);
		    DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
		    return _bs.get(property);
        } catch (Exception e) {
		    return Direction.NORTH;
        }
	}}.getDirection(new BlockPos((int)x,(int)y,(int)z))) == Direction.SOUTH)) {if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:dungeon_blocks").toLowerCase(java.util.Locale.ENGLISH))).contains((world.getBlockState(new BlockPos((int)x,(int)(y-14),(int)(z-2)))).getBlock()))) {if(!world.getWorld().isRemote){
	Template template=((ServerWorld)world.getWorld()).getSaveHandler().getStructureTemplateManager()
		.getTemplateDefaulted(new ResourceLocation("laputa" ,"testglacialisroomnodoors"));

	if(template!=null){
		template.addBlocksToWorld(world,
			new BlockPos((int) (x-15),(int) (y-14),(int) (z-31)),
				new PlacementSettings()
						.setRotation(Rotation.NONE)
						.setMirror(Mirror.NONE)
						.setChunk(null)
						.setIgnoreEntities(false));
	}
}
}else{

	}

	

}
