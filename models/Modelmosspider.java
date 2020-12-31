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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
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