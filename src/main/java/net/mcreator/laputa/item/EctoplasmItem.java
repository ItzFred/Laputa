
package net.mcreator.laputa.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.laputa.itemgroup.LaputaItemGroup;
import net.mcreator.laputa.LaputaModElements;

@LaputaModElements.ModElement.Tag
public class EctoplasmItem extends LaputaModElements.ModElement {
	@ObjectHolder("laputa:ectoplasm")
	public static final Item block = null;
	public EctoplasmItem(LaputaModElements instance) {
		super(instance, 242);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(LaputaItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("ectoplasm");
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
