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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		All.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Tentacles.rotateAngleY = f2 / 20.f;
		this.Tentacles2.rotateAngleY = f2 / 20.f;
	}
}