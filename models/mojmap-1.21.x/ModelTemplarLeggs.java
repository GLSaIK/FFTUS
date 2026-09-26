// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelTemplarLeggs<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "templarleggs"), "main");
	private final ModelPart TemplarLeggins;
	private final ModelPart RightLeg2;
	private final ModelPart LeftLeg2;

	public ModelTemplarLeggs(ModelPart root) {
		this.TemplarLeggins = root.getChild("TemplarLeggins");
		this.RightLeg2 = this.TemplarLeggins.getChild("RightLeg2");
		this.LeftLeg2 = this.TemplarLeggins.getChild("LeftLeg2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition TemplarLeggins = partdefinition.addOrReplaceChild("TemplarLeggins", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition RightLeg2 = TemplarLeggins.addOrReplaceChild("RightLeg2",
				CubeListBuilder.create().texOffs(48, 65)
						.addBox(-2.5F, 5.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(28, 75)
						.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 107)
						.addBox(-2.7F, 5.73F, -2.7F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition LeftLeg2 = TemplarLeggins.addOrReplaceChild("LeftLeg2",
				CubeListBuilder.create().texOffs(28, 65)
						.addBox(-2.4F, 5.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(28, 85)
						.addBox(-2.4F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 107)
						.addBox(-2.2F, 5.73F, -2.7F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		TemplarLeggins.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}