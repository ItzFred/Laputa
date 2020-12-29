
package net.mcreator.laputa.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.laputa.itemgroup.LaputaItemGroup;
import net.mcreator.laputa.LaputaModElements;

@LaputaModElements.ModElement.Tag
public class LaputanShovelItem extends LaputaModElements.ModElement {
	@ObjectHolder("laputa:laputan_shovel")
	public static final Item block = null;
	public LaputanShovelItem(LaputaModElements instance) {
		super(instance, 141);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
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
		}, 1, -3f, new Item.Properties().group(LaputaItemGroup.tab)) {
		}.setRegistryName("laputan_shovel"));
	}
}
