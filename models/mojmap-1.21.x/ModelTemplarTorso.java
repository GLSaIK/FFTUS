// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelTemplarTorso<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "templartorso"), "main");
	private final ModelPart TemplarTorso;
	private final ModelPart waist;
	private final ModelPart leftArm2;
	private final ModelPart rightArm2;

	public ModelTemplarTorso(ModelPart root) {
		this.TemplarTorso = root.getChild("TemplarTorso");
		this.waist = this.TemplarTorso.getChild("waist");
		this.leftArm2 = this.TemplarTorso.getChild("leftArm2");
		this.rightArm2 = this.TemplarTorso.getChild("rightArm2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition TemplarTorso = partdefinition.addOrReplaceChild("TemplarTorso", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition waist = TemplarTorso.addOrReplaceChild("waist",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, 0.0F, -2.5F, 8.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(32, 41)
						.addBox(-4.0F, 0.25F, -3.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 43)
						.addBox(-4.0F, 0.25F, 2.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 12)
						.addBox(-4.0F, 1.25F, -2.75F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(25, 96)
						.addBox(-4.0F, 12.25F, -2.75F, 8.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(1, 53)
						.addBox(-4.5F, 9.75F, -3.0F, 9.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = waist
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(26, 0).addBox(-5.0F, -6.0F, 0.0F, 10.0F, 12.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 6.25F, 4.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r2 = waist.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(16, 41).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 8.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 12.25F, 4.25F, 0.0436F, 0.0F, 0.0F));

		PartDefinition leftArm2 = TemplarTorso.addOrReplaceChild("leftArm2",
				CubeListBuilder.create().texOffs(0, 17)
						.addBox(-1.75F, -1.75F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(42, 48)
						.addBox(2.8F, 5.25F, -3.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(47, -1)
						.addBox(2.75F, 8.25F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(54, 1)
						.addBox(3.8F, 8.25F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(46, 4)
						.addBox(2.75F, 3.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(46, 4)
						.addBox(2.75F, 4.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(48, 7)
						.addBox(2.75F, 2.25F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(58, 14)
						.addBox(2.75F, 9.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(22, 34)
						.addBox(-1.0F, -2.25F, -3.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition rightArm2 = TemplarTorso.addOrReplaceChild("rightArm2", CubeListBuilder.create().texOffs(20, 17)
				.addBox(-3.25F, -1.75F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(58, 14).mirror()
				.addBox(-3.75F, 9.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(48, 7)
				.mirror().addBox(-3.75F, 2.25F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(42, 48).mirror().addBox(-3.8F, 5.25F, -3.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(54, 1).mirror()
				.addBox(-3.8F, 8.25F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(46, 4)
				.mirror().addBox(-3.75F, 4.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(46, 4).mirror().addBox(-3.75F, 3.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.mirror(false).texOffs(47, -1).mirror()
				.addBox(-3.75F, 8.25F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 34)
				.addBox(-4.0F, -2.25F, -3.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		TemplarTorso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}