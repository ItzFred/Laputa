
package net.mcreator.laputa.item;

@LaputaModElements.ModElement.Tag
public class LaputanPickaxeItem extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:laputan_pickaxe")
	public static final Item block = null;

	public LaputanPickaxeItem(LaputaModElements instance) {
		super(instance, 138);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
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
		}, 1, -3f, new Item.Properties().group(LaputaItemGroup.tab)) {

		}.setRegistryName("laputan_pickaxe"));
	}

}
