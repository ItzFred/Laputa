// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelorphanim2 extends EntityModel<Entity> {
	private final ModelRenderer rings;
	private final ModelRenderer head;

	public Modelorphanim2() {
		textureWidth = 400;
		textureHeight = 400;

		rings = new ModelRenderer(this);
		rings.setRotationPoint(0.0F, 24.0F, 0.0F);
		rings.setTextureOffset(104, 104).addBox(-21.0F, -43.0F, -3.0F, 41.0F, 41.0F, 6.0F, 0.0F, false);
		rings.setTextureOffset(0, 48).addBox(-3.0F, -45.0F, -23.0F, 6.0F, 45.0F, 46.0F, 0.0F, false);
		rings.setTextureOffset(60, 166).addBox(-2.0F, -44.0F, -22.0F, 4.0F, 43.0F, 44.0F, 0.0F, false);
		rings.setTextureOffset(0, 0).addBox(-21.0F, -26.0F, -21.0F, 41.0F, 6.0F, 42.0F, 0.0F, false);
		rings.setTextureOffset(98, 48).addBox(-20.0F, -25.0F, -20.0F, 39.0F, 4.0F, 40.0F, 0.0F, false);
		rings.setTextureOffset(1, 201).addBox(-19.0F, -42.0F, -3.0F, 37.0F, 39.0F, 6.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(58, 58).addBox(-6.0F, -29.0F, -6.0F, 12.0F, 12.0F, 12.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		rings.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
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
		this.rings.rotateAngleY = f2 / 20.f;
	}
}