
package net.mcreator.laputa.world.biome;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class YateveoBiome extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:yateveo")
	public static final CustomBiome biome = null;

	public YateveoBiome(LaputaModElements instance) {
		super(instance, 229);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.LUSH);
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f).depth(0.1f).scale(0.2f).temperature(0.5f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.JUNGLE).waterColor(-16751002).waterFogColor(-16751002).surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState())));

			setRegistryName("yateveo");

		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(double posX, double posZ) {
			return -13434829;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor() {
			return -13434829;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -16764109;
		}

	}

}
