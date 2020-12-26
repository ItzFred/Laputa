
package net.mcreator.laputa.item;

@LaputaModElements.ModElement.Tag
public class LaputanAxeItem extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:laputan_axe")
	public static final Item block = null;

	public LaputanAxeItem(LaputaModElements instance) {
		super(instance, 139);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 850;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 7f;
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
		}, 1, -3f, new Item.Properties().group(LaputaItemGroup.tab)) {

		}.setRegistryName("laputan_axe"));
	}

}
