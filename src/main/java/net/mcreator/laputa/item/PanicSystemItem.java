
package net.mcreator.laputa.item;

@LaputaModElements.ModElement.Tag
public class PanicSystemItem extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:panic_system")
	public static final Item block = null;

	public PanicSystemItem(LaputaModElements instance) {
		super(instance, 187);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(LaputaItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("panic_system");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u00A78Accessory"));
			list.add(new StringTextComponent("\u00A78Press I to open Accessory Bag"));
			list.add(new StringTextComponent("\u00A79Movement Speed \u00A77increased by \u00A74how low your HP is."));
		}

	}

}
