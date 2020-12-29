
package net.mcreator.laputa.block;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class PathosBrickWallBlock extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:pathos_brick_wall")
	public static final Block block = null;

	public PathosBrickWallBlock(LaputaModElements instance) {
		super(instance, 202);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LaputaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends WallBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2.75f, 10.5f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("pathos_brick_wall");
		}

		private boolean func_220113_a(BlockState state, boolean checkattach, Direction face) {
			boolean flag = state.getBlock() instanceof WallBlock
					|| state.getBlock() instanceof FenceGateBlock && FenceGateBlock.isParallel(state, face);
			return !cannotAttach(state.getBlock()) && checkattach || flag;
		}

		@Override /* failed to load code for net.minecraft.block.WallBlock */
		@Override /* failed to load code for net.minecraft.block.WallBlock */

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.GRAY;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
