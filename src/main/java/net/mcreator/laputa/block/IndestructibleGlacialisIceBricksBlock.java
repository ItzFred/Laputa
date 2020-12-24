
package net.mcreator.laputa.block;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class IndestructibleGlacialisIceBricksBlock extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:indestructible_glacialis_ice_bricks")
	public static final Block block = null;

	public IndestructibleGlacialisIceBricksBlock(LaputaModElements instance) {
		super(instance, 110);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ICE).sound(SoundType.GLASS).hardnessAndResistance(-1, 3600000).lightValue(0).slipperiness(0.8f));

			setRegistryName("indestructible_glacialis_ice_bricks");
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
