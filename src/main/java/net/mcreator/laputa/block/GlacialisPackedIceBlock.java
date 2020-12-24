
package net.mcreator.laputa.block;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class GlacialisPackedIceBlock extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:glacialis_packed_ice")
	public static final Block block = null;

	public GlacialisPackedIceBlock(LaputaModElements instance) {
		super(instance, 47);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LaputaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.PACKED_ICE).sound(SoundType.GLASS).hardnessAndResistance(0.6000000000000001f, 10f).lightValue(0)
							.slipperiness(0.8f));

			setRegistryName("glacialis_packed_ice");
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