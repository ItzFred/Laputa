// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelFleshFish extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;

	public ModelFleshFish() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(1.5F, 15.0F, -1.5F);
		bone.setTextureOffset(0, 16).addBox(-3.5F, -4.5F, -4.5F, 4.0F, 7.0F, 9.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -12.0F, 5.0F, 6.0F, 10.0F, 0.0F, false);
		bone.setTextureOffset(32, 15).addBox(-1.5F, -9.5F, -7.5F, 0.0F, 5.0F, 9.0F, 0.0F, false);
		bone.setTextureOffset(40, 0).addBox(-4.0F, -1.0F, -11.5F, 5.0F, 2.0F, 7.0F, 0.0F, false);
		bone.setTextureOffset(0, 32).addBox(-2.5F, -3.0F, 4.0F, 2.0F, 4.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 5).addBox(-1.5F, -5.0F, 4.0F, 0.0F, 8.0F, 11.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.5F, 17.5F, -5.5F);
		setRotationAngle(bone2, 0.5672F, 0.0F, 0.0F);
		bone2.setTextureOffset(17, 24).addBox(-2.0F, -1.0F, -6.0F, 3.0F, 3.0F, 9.0F, 0.0F, false);
		bone2.setTextureOffset(30, 8).addBox(-2.0F, -1.9144F, -5.9218F, 3.0F, 1.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}