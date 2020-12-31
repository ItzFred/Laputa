// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelEctojelly extends EntityModel<Entity> {
	private final ModelRenderer bone3;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;

	public ModelEctojelly() {
		textureWidth = 64;
		textureHeight = 64;

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 8.0F, -1.5F);
		setRotationAngle(bone3, 0.0873F, 0.0F, 0.0F);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(bone);
		bone.setTextureOffset(0, 0).addBox(-8.0F, -13.9302F, -7.9002F, 16.0F, 14.0F, 16.0F, 0.0F, false);
		bone.setTextureOffset(0, 30).addBox(-8.0F, 0.0698F, 0.0998F, 16.0F, 16.0F, 0.0F, 0.0F, false);
		bone.setTextureOffset(0, 14).addBox(0.0F, 0.0698F, -7.9002F, 0.0F, 16.0F, 16.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0698F, 0.0998F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 0.7854F, 0.0F);
		bone2.setTextureOffset(0, 14).addBox(0.0F, 0.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
		bone2.setTextureOffset(0, 30).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone3.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bone2.rotateAngleY = f2;
		this.bone.rotateAngleY = f2 / 20.f;
	}
}