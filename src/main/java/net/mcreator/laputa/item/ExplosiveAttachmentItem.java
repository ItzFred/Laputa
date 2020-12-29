
package net.mcreator.laputa.item;

@LaputaModElements.ModElement.Tag
public class ExplosiveAttachmentItem extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:explosive_attachment")
	public static final Item block = null;

	public ExplosiveAttachmentItem(LaputaModElements instance) {
		super(instance, 185);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(LaputaItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("explosive_attachment");
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
			list.add(new StringTextComponent("\u00EF\u00BF\u00BD8Accessory"));
			list.add(new StringTextComponent("\u00EF\u00BF\u00BD8Press I to open Accessory Bag"));
			list.add(new StringTextComponent(
					"\u00EF\u00BF\u00BD7Has a \u00EF\u00BF\u00BD433% chance \u00EF\u00BF\u00BD7to cause an \u00EF\u00BF\u00BD9explosion upon killing an Enemy"));
		}

	}

}
