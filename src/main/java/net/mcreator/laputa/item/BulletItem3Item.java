
package net.mcreator.laputa.item;

@LaputaModElements.ModElement.Tag
public class BulletItem3Item extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:bullet_item_3")
	public static final Item block = null;

	public BulletItem3Item(LaputaModElements instance) {
		super(instance, 158);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("bullet_item_3");
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
