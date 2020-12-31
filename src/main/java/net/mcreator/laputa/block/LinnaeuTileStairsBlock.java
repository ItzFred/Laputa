
package net.mcreator.laputa.block;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class LinnaeuTileStairsBlock extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:linnaeu_tile_stairs")
	public static final Block block = null;

	public LinnaeuTileStairsBlock(LaputaModElements instance) {
		super(instance, 45);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LaputaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StairsBlock {

		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 10f)).getDefaultState(),

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2f, 10f).lightValue(0).harvestLevel(1)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("linnaeu_tile_stairs");
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
