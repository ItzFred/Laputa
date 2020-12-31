
package net.mcreator.laputa.particle;

@LaputaModElements.ModElement.Tag
public class YateveoLeavesFallParticle extends LaputaModElements.ModElement {

	public static final BasicParticleType particle = new BasicParticleType(false);

	public YateveoLeavesFallParticle(LaputaModElements instance) {
		super(instance, 267);

		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
		event.getRegistry().register(particle.setRegistryName("yateveo_leaves_fall"));
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void registerParticle(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
	}

	@OnlyIn(Dist.CLIENT)
	private static class CustomParticle extends SpriteTexturedParticle {

		private final IAnimatedSprite spriteSet;

		protected CustomParticle(World world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
			super(world, x, y, z);
			this.spriteSet = spriteSet;

			this.setSize((float) 0.2, (float) 0.2);
			this.particleScale *= (float) 0.4;

			this.maxAge = 60;

			this.particleGravity = (float) 0.3;
			this.canCollide = true;

			this.motionX = vx * 0;
			this.motionY = vy * 0;
			this.motionZ = vz * 0;

			this.selectSpriteWithAge(spriteSet);
		}

		@Override
		public int getBrightnessForRender(float partialTick) {
			return 15728880;
		}

		@Override
		public IParticleRenderType getRenderType() {
			return IParticleRenderType.PARTICLE_SHEET_LIT;
		}

		@Override
		public void tick() {
			super.tick();

			if (!this.isExpired) {
				this.setSprite(this.spriteSet.get((this.age / 3) % 2 + 1, 2));
			}

		}

	}

	@OnlyIn(Dist.CLIENT)
	private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public CustomParticleFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(BasicParticleType typeIn, World worldIn, double x, double y, double z, double xSpeed, double ySpeed,
				double zSpeed) {
			return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

}
