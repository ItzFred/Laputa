
package net.mcreator.laputa.item;

@LaputaModElements.ModElement.Tag
public class EnchantedWaterBottleItem extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:enchanted_water_bottle")
	public static final Item block = null;

	public EnchantedWaterBottleItem(LaputaModElements instance) {
		super(instance, 44);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(LaputaItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("enchanted_water_bottle");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
