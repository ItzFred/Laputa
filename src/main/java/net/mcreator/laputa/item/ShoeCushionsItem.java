
package net.mcreator.laputa.item;

@LaputaModElements.ModElement.Tag
public class ShoeCushionsItem extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:shoe_cushions")
	public static final Item block = null;

	public ShoeCushionsItem(LaputaModElements instance) {
		super(instance, 184);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(LaputaItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("shoe_cushions");
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
			list.add(new StringTextComponent("\u00EF\u00BF\u00BD4Nullifies \u00EF\u00BF\u00BD9Fall Damage"));
		}

	}

}
