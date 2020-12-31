
package net.mcreator.laputa.block;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class IndustrialBricksBlock extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:industrial_bricks")
	public static final Block block = null;

	public IndustrialBricksBlock(LaputaModElements instance) {
		super(instance, 249);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LaputaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3f, 9f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("industrial_bricks");
		}

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
