
package net.mcreator.laputa.block;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class BrassBlockBlock extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:brass_block")
	public static final Block block = null;

	public BrassBlockBlock(LaputaModElements instance) {
		super(instance, 116);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LaputaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(5f, 6f).lightValue(0).harvestLevel(2)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("brass_block");
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
