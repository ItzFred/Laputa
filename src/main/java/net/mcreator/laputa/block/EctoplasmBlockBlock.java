
package net.mcreator.laputa.block;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class EctoplasmBlockBlock extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:ectoplasm_block")
	public static final Block block = null;

	public EctoplasmBlockBlock(LaputaModElements instance) {
		super(instance, 243);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LaputaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.WET_GRASS).hardnessAndResistance(2f, 4f).lightValue(15));

			setRegistryName("ectoplasm_block");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public void onEntityWalk(World world, BlockPos pos, Entity entity) {
			super.onEntityWalk(world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				EctoplasmBlockEntityWalksOnTheBlockProcedure.executeProcedure($_dependencies);
			}
		}

	}

}
