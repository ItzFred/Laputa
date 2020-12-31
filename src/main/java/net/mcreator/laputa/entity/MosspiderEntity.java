
package net.mcreator.laputa.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.laputa.itemgroup.LaputaItemGroup;
import net.mcreator.laputa.LaputaModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@LaputaModElements.ModElement.Tag
public class MosspiderEntity extends LaputaModElements.ModElement {
	public static EntityType entity = null;
	public MosspiderEntity(LaputaModElements instance) {
		super(instance, 248);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("mosspider")
						.setRegistryName("mosspider");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -14677482, -9687694, new Item.Properties().group(LaputaItemGroup.tab))
				.setRegistryName("mosspider_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelmosspider(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("laputa:textures/mosspider.png");
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
			experienceValue = 4;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, (float) 0.7));
			this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 0.8));
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.7999999999999999);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6);
		}
	}

	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelmosspider extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer body0;
		private final ModelRenderer body1;
		private final ModelRenderer legrightback;
		private final ModelRenderer legleftback;
		private final ModelRenderer legrightmiddle;
		private final ModelRenderer lefleftmiddle;
		private final ModelRenderer legrightfront;
		private final ModelRenderer legleftfront;
		public Modelmosspider() {
			textureWidth = 128;
			textureHeight = 128;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 15.0F, -3.0F);
			head.setTextureOffset(36, 38).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			body0 = new ModelRenderer(this);
			body0.setRotationPoint(0.0F, 15.0F, 0.0F);
			body0.setTextureOffset(0, 0).addBox(-6.0F, -6.0F, -4.0F, 12.0F, 12.0F, 14.0F, 0.0F, false);
			body1 = new ModelRenderer(this);
			body1.setRotationPoint(0.0F, 15.0F, 9.0F);
			body1.setTextureOffset(0, 26).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 8.0F, 12.0F, 0.0F, false);
			legrightback = new ModelRenderer(this);
			legrightback.setRotationPoint(4.0F, 15.0F, 2.0F);
			setRotationAngle(legrightback, 0.0F, -0.2618F, 0.5236F);
			legrightback.setTextureOffset(0, 46).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			legleftback = new ModelRenderer(this);
			legleftback.setRotationPoint(-4.0F, 15.0F, 2.0F);
			setRotationAngle(legleftback, 0.0F, 0.3491F, -0.6109F);
			legleftback.setTextureOffset(38, 8).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			legrightmiddle = new ModelRenderer(this);
			legrightmiddle.setRotationPoint(4.0F, 15.0F, 0.0F);
			setRotationAngle(legrightmiddle, 0.0F, 0.0F, 0.5236F);
			legrightmiddle.setTextureOffset(38, 4).addBox(-1.0F, -1.0F, 0.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			lefleftmiddle = new ModelRenderer(this);
			lefleftmiddle.setRotationPoint(-4.0F, 15.0F, 1.0F);
			setRotationAngle(lefleftmiddle, 0.0F, 0.0F, -0.6109F);
			lefleftmiddle.setTextureOffset(38, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			legrightfront = new ModelRenderer(this);
			legrightfront.setRotationPoint(4.0F, 15.0F, -1.0F);
			setRotationAngle(legrightfront, 0.0F, 0.2618F, 0.5236F);
			legrightfront.setTextureOffset(32, 26).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
			legleftfront = new ModelRenderer(this);
			legleftfront.setRotationPoint(-4.0F, 15.0F, -1.0F);
			setRotationAngle(legleftfront, 0.0F, -0.2618F, -0.6109F);
			legleftfront.setTextureOffset(32, 32).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			body0.render(matrixStack, buffer, packedLight, packedOverlay);
			body1.render(matrixStack, buffer, packedLight, packedOverlay);
			legrightback.render(matrixStack, buffer, packedLight, packedOverlay);
			legleftback.render(matrixStack, buffer, packedLight, packedOverlay);
			legrightmiddle.render(matrixStack, buffer, packedLight, packedOverlay);
			lefleftmiddle.render(matrixStack, buffer, packedLight, packedOverlay);
			legrightfront.render(matrixStack, buffer, packedLight, packedOverlay);
			legleftfront.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.lefleftmiddle.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.legrightfront.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.legleftfront.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.legleftback.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.legrightmiddle.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.legrightback.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
