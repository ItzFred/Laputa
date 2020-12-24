
package net.mcreator.laputa.item;

@LaputaModElements.ModElement.Tag
public class DazeberryItem extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:dazeberry")
	public static final Item block = null;

	public DazeberryItem(LaputaModElements instance) {
		super(instance, 65);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(LaputaItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.6f)

							.build()));
			setRegistryName("dazeberry");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
