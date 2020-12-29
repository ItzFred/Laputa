
package net.mcreator.laputa.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.laputa.itemgroup.LaputaItemGroup;
import net.mcreator.laputa.LaputaModElements;

import java.util.List;
import java.util.Collections;

@LaputaModElements.ModElement.Tag
public class GlacialisPackedIceStairsBlock extends LaputaModElements.ModElement {
	@ObjectHolder("laputa:glacialis_packed_ice_stairs")
	public static final Block block = null;
	public GlacialisPackedIceStairsBlock(LaputaModElements instance) {
		super(instance, 199);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(LaputaItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.6000000000000001f, 10f)).getDefaultState(),
					Block.Properties.create(Material.PACKED_ICE).sound(SoundType.GLASS).hardnessAndResistance(0.6000000000000001f, 10f).lightValue(0)
							.slipperiness(0.8f));
			setRegistryName("glacialis_packed_ice_stairs");
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
