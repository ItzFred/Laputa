
package net.mcreator.laputa.item;

@LaputaModElements.ModElement.Tag
public class LaputanHoeItem extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:laputan_hoe")
	public static final Item block = null;

	public LaputanHoeItem(LaputaModElements instance) {
		super(instance, 142);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 850;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LaputanDiamondItem.block, (int) (1)));
			}
		}, -3f, new Item.Properties().group(LaputaItemGroup.tab)) {

		}.setRegistryName("laputan_hoe"));
	}

}
