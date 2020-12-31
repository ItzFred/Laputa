
package net.mcreator.laputa.item;

@LaputaModElements.ModElement.Tag
public class BrassScrapItem extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:brass_scrap")
	public static final Item block = null;

	public BrassScrapItem(LaputaModElements instance) {
		super(instance, 234);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(LaputaItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("brass_scrap");
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