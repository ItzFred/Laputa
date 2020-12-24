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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}