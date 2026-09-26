// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelTemplarBoot<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "templarboot"), "main");
	private final ModelPart TemplarBoots;
	private final ModelPart leftBoot;
	private final ModelPart rightBoot;

	public ModelTemplarBoot(ModelPart root) {
		this.TemplarBoots = root.getChild("TemplarBoots");
		this.leftBoot = this.TemplarBoots.getChild("leftBoot");
		this.rightBoot = this.TemplarBoots.getChild("rightBoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition TemplarBoots = partdefinition.addOrReplaceChild("TemplarBoots", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leftBoot = TemplarBoots.addOrReplaceChild("leftBoot", CubeListBuilder.create().texOffs(0, 71)
				.addBox(-2.25F, 9.75F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition rightBoot = TemplarBoots.addOrReplaceChild("rightBoot", CubeListBuilder.create().texOffs(0, 80)
				.addBox(-2.75F, 9.75F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, -12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		TemplarBoots.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}