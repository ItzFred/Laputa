
package net.mcreator.laputa.entity;

import net.minecraft.block.material.Material;

@LaputaModElements.ModElement.Tag
public class OphanimEntity extends LaputaModElements.ModElement {

	public static EntityType entity = null;

	public OphanimEntity(LaputaModElements instance) {
		super(instance, 127);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(2.5f, 2.5f)).build("ophanim")
						.setRegistryName("ophanim");

		elements.entities.add(() -> entity);

		elements.items.add(() -> new SpawnEggItem(entity, -13421773, -3368704, new Item.Properties().group(LaputaItemGroup.tab))
				.setRegistryName("ophanim_spawn_egg"));

	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_model(), 2.5f) {

				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("laputa:textures/angeluv.png");
				}
			};
		});

	}

	public static class CustomEntity extends MonsterEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);

			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.goalSelector.addGoal(1, new Goal() {
				{
					this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
				}

				public boolean shouldExecute() {
					if (CustomEntity.this.getAttackTarget() != null && !CustomEntity.this.getMoveHelper().isUpdating()) {
						return true;
					} else {
						return false;
					}
				}

				@Override
				public boolean shouldContinueExecuting() {
					return CustomEntity.this.getMoveHelper().isUpdating() && CustomEntity.this.getAttackTarget() != null
							&& CustomEntity.this.getAttackTarget().isAlive();
				}

				@Override
				public void startExecuting() {
					LivingEntity livingentity = CustomEntity.this.getAttackTarget();
					Vec3d vec3d = livingentity.getEyePosition(1);
					CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
				}

				@Override
				public void tick() {
					LivingEntity livingentity = CustomEntity.this.getAttackTarget();
					if (CustomEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
						CustomEntity.this.attackEntityAsMob(livingentity);
					} else {
						double d0 = CustomEntity.this.getDistanceSq(livingentity);
						if (d0 < 16) {
							Vec3d vec3d = livingentity.getEyePosition(1);
							CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
						}
					}
				}
			});
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8, 20) {

				@Override
				protected Vec3d getPosition() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}

			});
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, AgeableEntity.class, false, false));
			this.targetSelector.addGoal(6, new HurtByTargetGoal(this));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {

			return false;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();

			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4);

			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25);

			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(15);

			if (this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.5D);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK);
			this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(1D);

			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.4);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();

			this.setNoGravity(true);

		}

	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	public static class Modelcustom_model extends EntityModel<Entity> {
		private final ModelRenderer octagon1;
		private final ModelRenderer octagon_r1;
		private final ModelRenderer octagon2;
		private final ModelRenderer octagon_r2;
		private final ModelRenderer octagon3;
		private final ModelRenderer octagon_r3;
		private final ModelRenderer Heas;

		public Modelcustom_model() {
			textureWidth = 128;
			textureHeight = 128;

			octagon1 = new ModelRenderer(this);
			octagon1.setRotationPoint(0.0F, 24.0F, 0.0F);
			octagon1.setTextureOffset(46, 0).addBox(-10.7696F, -2.5F, -26.0F, 21.0F, 5.0F, 2.0F, 0.0F, false);
			octagon1.setTextureOffset(0, 0).addBox(-10.7696F, -2.5F, 24.0F, 21.0F, 5.0F, 2.0F, 0.0F, false);
			octagon1.setTextureOffset(30, 12).addBox(24.0F, -2.5F, -10.7696F, 2.0F, 5.0F, 21.0F, 0.0F, false);
			octagon1.setTextureOffset(0, 7).addBox(-26.0F, -2.5F, -10.7696F, 2.0F, 5.0F, 21.0F, 0.0F, false);

			octagon_r1 = new ModelRenderer(this);
			octagon_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			octagon1.addChild(octagon_r1);
			setRotationAngle(octagon_r1, 0.0F, -0.7854F, 0.0F);
			octagon_r1.setTextureOffset(0, 7).addBox(-26.0F, -2.5F, -10.7696F, 2.0F, 5.0F, 21.0F, 0.0F, false);
			octagon_r1.setTextureOffset(30, 12).addBox(24.0F, -2.5F, -10.7696F, 2.0F, 5.0F, 21.0F, 0.0F, false);
			octagon_r1.setTextureOffset(0, 0).addBox(-10.7696F, -2.5F, 24.0F, 21.0F, 5.0F, 2.0F, 0.0F, false);
			octagon_r1.setTextureOffset(46, 0).addBox(-10.7696F, -2.5F, -26.0F, 21.0F, 5.0F, 2.0F, 0.0F, false);

			octagon2 = new ModelRenderer(this);
			octagon2.setRotationPoint(0.0F, 24.0F, 0.0F);
			octagon2.setTextureOffset(0, 33).addBox(-2.5F, -9.734F, -23.5F, 5.0F, 19.0F, 2.0F, 0.0F, false);
			octagon2.setTextureOffset(14, 33).addBox(-2.5F, -9.734F, 21.5F, 5.0F, 19.0F, 2.0F, 0.0F, false);
			octagon2.setTextureOffset(49, 54).addBox(-2.5F, 21.5F, -9.734F, 5.0F, 2.0F, 19.0F, 0.0F, false);
			octagon2.setTextureOffset(0, 54).addBox(-2.5F, -23.5F, -9.734F, 5.0F, 2.0F, 19.0F, 0.0F, false);

			octagon_r2 = new ModelRenderer(this);
			octagon_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			octagon2.addChild(octagon_r2);
			setRotationAngle(octagon_r2, -0.7854F, 0.0F, 0.0F);
			octagon_r2.setTextureOffset(0, 54).addBox(-2.5F, -23.5F, -9.734F, 5.0F, 2.0F, 19.0F, 0.0F, false);
			octagon_r2.setTextureOffset(49, 54).addBox(-2.5F, 21.5F, -9.734F, 5.0F, 2.0F, 19.0F, 0.0F, false);
			octagon_r2.setTextureOffset(14, 33).addBox(-2.5F, -9.734F, 21.5F, 5.0F, 19.0F, 2.0F, 0.0F, false);
			octagon_r2.setTextureOffset(0, 33).addBox(-2.5F, -9.734F, -23.5F, 5.0F, 19.0F, 2.0F, 0.0F, false);

			octagon3 = new ModelRenderer(this);
			octagon3.setRotationPoint(0.0F, 24.0F, 0.0F);
			octagon3.setTextureOffset(44, 75).addBox(-8.6985F, 19.0F, -2.5F, 17.0F, 2.0F, 5.0F, 0.0F, false);
			octagon3.setTextureOffset(0, 75).addBox(-8.6985F, -21.0F, -2.5F, 17.0F, 2.0F, 5.0F, 0.0F, false);
			octagon3.setTextureOffset(92, 0).addBox(19.0F, -8.6985F, -2.5F, 2.0F, 17.0F, 5.0F, 0.0F, false);
			octagon3.setTextureOffset(114, 0).addBox(-21.0F, -8.6985F, -2.5F, 2.0F, 17.0F, 5.0F, 0.0F, false);

			octagon_r3 = new ModelRenderer(this);
			octagon_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			octagon3.addChild(octagon_r3);
			setRotationAngle(octagon_r3, 0.0F, 0.0F, 0.7854F);
			octagon_r3.setTextureOffset(114, 0).addBox(-21.0F, -8.6985F, -2.5F, 2.0F, 17.0F, 5.0F, 0.0F, false);
			octagon_r3.setTextureOffset(92, 0).addBox(19.0F, -8.6985F, -2.5F, 2.0F, 17.0F, 5.0F, 0.0F, false);
			octagon_r3.setTextureOffset(0, 75).addBox(-8.6985F, -21.0F, -2.5F, 17.0F, 2.0F, 5.0F, 0.0F, false);
			octagon_r3.setTextureOffset(44, 75).addBox(-8.6985F, 19.0F, -2.5F, 17.0F, 2.0F, 5.0F, 0.0F, false);

			Heas = new ModelRenderer(this);
			Heas.setRotationPoint(0.0F, 23.0F, 0.0F);
			Heas.setTextureOffset(88, 22).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			octagon1.render(matrixStack, buffer, packedLight, packedOverlay);
			octagon2.render(matrixStack, buffer, packedLight, packedOverlay);
			octagon3.render(matrixStack, buffer, packedLight, packedOverlay);
			Heas.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.octagon1.rotateAngleY = f2 / 20.f;
			this.octagon2.rotateAngleY = f2 / 20.f;
			this.octagon3.rotateAngleY = f2 / 20.f;
			this.octagon_r2.rotateAngleY = f2 / 20.f;
			this.octagon_r3.rotateAngleY = f2 / 20.f;
			this.Heas.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Heas.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.octagon_r1.rotateAngleY = f2 / 20.f;
		}
	}

}
