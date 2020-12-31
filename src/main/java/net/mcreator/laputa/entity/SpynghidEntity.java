
package net.mcreator.laputa.entity;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class SpynghidEntity extends LaputaModElements.ModElement {

	public static EntityType entity = null;

	public SpynghidEntity(LaputaModElements instance) {
		super(instance, 247);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("spynghid")
						.setRegistryName("spynghid");

		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -16185058, -13369345, new Item.Properties().group(LaputaItemGroup.tab))
				.setRegistryName("spynghid_spawn_egg"));

	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelspynghid(), 0.7f) {

				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("laputa:textures/sypnghid.png");
				}
			};
		});

	}

	public static class CustomEntity extends CreatureEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);

		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(3, new SwimGoal(this));
			this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.5));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();

			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);

			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16);

			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);

		}

	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	public static class Modelspynghid extends EntityModel<Entity> {
		private final ModelRenderer legleftfront;
		private final ModelRenderer legrightfront;
		private final ModelRenderer legrightback;
		private final ModelRenderer legleftback;
		private final ModelRenderer head;
		private final ModelRenderer torso;

		public Modelspynghid() {
			textureWidth = 64;
			textureHeight = 64;

			legleftfront = new ModelRenderer(this);
			legleftfront.setRotationPoint(2.0F, 24.0F, 5.0F);
			legleftfront.setTextureOffset(8, 37).addBox(-6.0F, -8.0F, -16.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

			legrightfront = new ModelRenderer(this);
			legrightfront.setRotationPoint(2.0F, 24.0F, 5.0F);
			legrightfront.setTextureOffset(16, 37).addBox(-2.0F, -8.0F, -16.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

			legrightback = new ModelRenderer(this);
			legrightback.setRotationPoint(2.0F, 24.0F, 5.0F);
			legrightback.setTextureOffset(0, 0).addBox(-2.0F, -8.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

			legleftback = new ModelRenderer(this);
			legleftback.setRotationPoint(2.0F, 24.0F, 5.0F);
			legleftback.setTextureOffset(0, 37).addBox(-6.0F, -8.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, 0.0F);
			head.setTextureOffset(34, 0).addBox(-8.0F, -24.0F, -13.0F, 14.0F, 10.0F, 0.0F, 0.0F, false);
			head.setTextureOffset(25, 30).addBox(-4.0F, -21.0F, -16.0F, 7.0F, 7.0F, 7.0F, 0.0F, false);

			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, 24.0F, 0.0F);
			torso.setTextureOffset(0, 0).addBox(-6.0F, -16.0F, -12.0F, 10.0F, 9.0F, 13.0F, 0.0F, false);
			torso.setTextureOffset(0, 22).addBox(-4.5F, -14.0F, 0.0F, 7.0F, 6.0F, 9.0F, 0.0F, false);
			torso.setTextureOffset(23, 23).addBox(-2.5F, -17.0F, 9.0F, 4.0F, 4.0F, 0.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			legleftfront.render(matrixStack, buffer, packedLight, packedOverlay);
			legrightfront.render(matrixStack, buffer, packedLight, packedOverlay);
			legrightback.render(matrixStack, buffer, packedLight, packedOverlay);
			legleftback.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			torso.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.legrightfront.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.legleftfront.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.legleftback.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.legrightback.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
