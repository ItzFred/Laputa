
package net.mcreator.laputa.block;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class CorpseBlockBlock extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:corpse_block")
	public static final Block block = null;

	public CorpseBlockBlock(LaputaModElements instance) {
		super(instance, 206);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LaputaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends FallingBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.EARTH).sound(SoundType.SWEET_BERRY_BUSH).hardnessAndResistance(1.05f, 10f).lightValue(0)
							.harvestLevel(1).harvestTool(ToolType.SHOVEL));

			setRegistryName("corpse_block");
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.DIRT;
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
