
package net.mcreator.laputa.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.laputa.itemgroup.LaputaItemGroup;
import net.mcreator.laputa.LaputaModElements;

@LaputaModElements.ModElement.Tag
public class MoonDustItem extends LaputaModElements.ModElement {
	@ObjectHolder("laputa:moon_dust")
	public static final Item block = null;
	public MoonDustItem(LaputaModElements instance) {
<<<<<<< HEAD
		super(instance, 45);
=======
		super(instance, 67);
>>>>>>> branch 'master' of https://github.com/ItzFred/Laputa.git
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(LaputaItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("moon_dust");
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
