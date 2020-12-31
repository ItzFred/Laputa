
package net.mcreator.laputa.entity;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class EctojellyEntity extends LaputaModElements.ModElement {

	public static EntityType entity = null;

	public EctojellyEntity(LaputaModElements instance) {
		super(instance, 231);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(1f, 2f)).build("ectojelly")
						.setRegistryName("ectojelly");

		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -16750849, -6684673, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("ectojelly_spawn_egg"));

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("laputa:glacialis")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;

			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 20, 1, 4));
		}

		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));

	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelEctojelly1(), 0.8f) {
				{
					this.addLayer(new GlowingLayer<>(this));
				}
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("laputa:textures/ectojellyuv.png");
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
			experienceValue = 1;
			setNoAI(false);

			enablePersistence();

			this.moveController = new MovementController(this) {
				@Override
				public void tick() {
					if (CustomEntity.this.areEyesInFluid(FluidTags.WATER))
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, 0.005, 0));

					if (this.action == MovementController.Action.MOVE_TO && !CustomEntity.this.getNavigator().noPath()) {
						double dx = this.posX - CustomEntity.this.getPosX();
						double dy = this.posY - CustomEntity.this.getPosY();
						double dz = this.posZ - CustomEntity.this.getPosZ();
						dy = dy / (double) MathHelper.sqrt(dx * dx + dy * dy + dz * dz);
						CustomEntity.this.rotationYaw = this.limitAngle(CustomEntity.this.rotationYaw,
								(float) (MathHelper.atan2(dz, dx) * (double) (180 / (float) Math.PI)) - 90, 90);
						CustomEntity.this.renderYawOffset = CustomEntity.this.rotationYaw;
						CustomEntity.this.setAIMoveSpeed(MathHelper.lerp(0.125f, CustomEntity.this.getAIMoveSpeed(),
								(float) (this.speed * CustomEntity.this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue())));
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, CustomEntity.this.getAIMoveSpeed() * dy * 0.1, 0));
					} else {
						CustomEntity.this.setAIMoveSpeed(0);
					}
				}
			};
			this.navigator = new SwimmerPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.goalSelector.addGoal(1, new PanicGoal(this, 0.7));
			this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 0.5, 40));
			this.goalSelector.addGoal(3, new LookRandomlyGoal(this));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.WATER;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(EctoplasmItem.block, (int) (1)));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fish.swim")), 0.15f, 1);
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cod.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cod.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();

			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);

			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14);

			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2);

			if (this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.5D);

		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader worldreader) {
			return worldreader.checkNoEntityCollision(this, VoxelShapes.create(this.getBoundingBox()));
		}

		@Override
		public boolean isPushedByWater() {
			return false;
		}

	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {

		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("laputa:textures/ectojellyuv.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}

	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	public static class ModelEctojelly1 extends EntityModel<Entity> {
		private final ModelRenderer All;
		private final ModelRenderer Tentacles2;
		private final ModelRenderer Tentacles;
		private final ModelRenderer Body;

		public ModelEctojelly1() {
			textureWidth = 64;
			textureHeight = 64;

			All = new ModelRenderer(this);
			All.setRotationPoint(0.0F, 8.0F, -1.5F);
			setRotationAngle(All, 0.0873F, 0.0F, 0.0F);

			Tentacles2 = new ModelRenderer(this);
			Tentacles2.setRotationPoint(0.0F, 0.0698F, 0.0998F);
			All.addChild(Tentacles2);
			setRotationAngle(Tentacles2, 0.0F, 0.7854F, 0.0F);
			Tentacles2.setTextureOffset(0, 14).addBox(0.0F, 0.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
			Tentacles2.setTextureOffset(0, 30).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);

			Tentacles = new ModelRenderer(this);
			Tentacles.setRotationPoint(0.0F, 0.0698F, 0.0998F);
			All.addChild(Tentacles);
			Tentacles.setTextureOffset(0, 30).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
			Tentacles.setTextureOffset(0, 14).addBox(0.0F, 0.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);

			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, 0.0F, 0.0F);
			All.addChild(Body);
			Body.setTextureOffset(0, 0).addBox(-8.0F, -13.9302F, -7.9002F, 16.0F, 14.0F, 16.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			All.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.Tentacles.rotateAngleY = f2 / 20.f;
			this.Tentacles2.rotateAngleY = f2 / 20.f;
		}
	}

}
