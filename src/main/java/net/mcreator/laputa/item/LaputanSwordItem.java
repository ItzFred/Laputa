
package net.mcreator.laputa.item;

@LaputaModElements.ModElement.Tag
public class LaputanSwordItem extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:laputan_sword")
	public static final Item block = null;

	public LaputanSwordItem(LaputaModElements instance) {
		super(instance, 140);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 850;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 4.5f;
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
		}, 3, -3f, new Item.Properties().group(LaputaItemGroup.tab)) {

		}.setRegistryName("laputan_sword"));
	}

}
