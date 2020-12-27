
package net.mcreator.laputa.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.laputa.itemgroup.LaputaItemGroup;
import net.mcreator.laputa.LaputaModElements;

import java.util.List;
import java.util.Collections;

@LaputaModElements.ModElement.Tag
public class Kaikadoium2Block extends LaputaModElements.ModElement {
	@ObjectHolder("laputa:kaikadoium_2")
	public static final Block block = null;
	public Kaikadoium2Block(LaputaModElements instance) {
		super(instance, 75);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LaputaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(-1, 3600000).lightValue(0));
			setRegistryName("kaikadoium_2");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
