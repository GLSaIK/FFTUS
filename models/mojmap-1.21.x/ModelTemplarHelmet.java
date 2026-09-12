// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelTemplarHelmet<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "templarhelmet"), "main");
	private final ModelPart TemplarHelmet;

	public ModelTemplarHelmet(ModelPart root) {
		this.TemplarHelmet = root.getChild("TemplarHelmet");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition TemplarHelmet = partdefinition.addOrReplaceChild("TemplarHelmet",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.5F, -10.5F, -4.5F, 9.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(20, 28)
						.addBox(3.5F, -5.5F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(36, 0)
						.addBox(-3.5F, -5.75F, 1.45F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 28)
						.addBox(-4.5F, -5.5F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = TemplarHelmet.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(26, 14).addBox(-2.5F, -2.5F, -5.0F, 4.0F, 5.0F, 9.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.25F, -2.25F, 0.5F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_r2 = TemplarHelmet.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -2.5F, -5.0F, 4.0F, 5.0F, 9.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, -2.25F, 0.5F, 0.0F, 0.0F, -0.0436F));

		return LayerDefinition.create(meshdefinition, 56, 56);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		TemplarHelmet.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}