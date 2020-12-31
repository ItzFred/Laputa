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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.legrightfront.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.legleftfront.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.legleftback.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.legrightback.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}