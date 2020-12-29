
package net.mcreator.laputa.world.biome;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class GlacialisBiome extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:glacialis")
	public static final CustomBiome biome = null;

	public GlacialisBiome(LaputaModElements instance) {
		super(instance, 228);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WATER);
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f).depth(0.1f).scale(0.2f).temperature(0.5f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.ICY).waterColor(-16777165).waterFogColor(-16777165).surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState())));

			setRegistryName("glacialis");

		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(double posX, double posZ) {
			return -3355444;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor() {
			return -3355444;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -16764058;
		}

	}

}
