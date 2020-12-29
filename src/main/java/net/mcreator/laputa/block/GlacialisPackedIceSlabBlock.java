
package net.mcreator.laputa.block;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class GlacialisPackedIceSlabBlock extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:glacialis_packed_ice_slab")
	public static final Block block = null;

	public GlacialisPackedIceSlabBlock(LaputaModElements instance) {
		super(instance, 198);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LaputaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends SlabBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.PACKED_ICE).sound(SoundType.GLASS).hardnessAndResistance(0.6000000000000001f, 10f).lightValue(0)
							.slipperiness(0.8f));

			setRegistryName("glacialis_packed_ice_slab");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
		}

	}

}
