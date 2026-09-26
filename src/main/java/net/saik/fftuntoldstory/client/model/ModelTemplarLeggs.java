package net.saik.fftuntoldstory.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelTemplarLeggs extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("fft_untold_story", "model_templar_leggs"), "main");
	public final ModelPart TemplarLeggins;
	public final ModelPart RightLeg2;
	public final ModelPart LeftLeg2;

	public ModelTemplarLeggs(ModelPart root) {
		super(root);
		this.TemplarLeggins = root.getChild("TemplarLeggins");
		this.RightLeg2 = this.TemplarLeggins.getChild("RightLeg2");
		this.LeftLeg2 = this.TemplarLeggins.getChild("LeftLeg2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition TemplarLeggins = partdefinition.addOrReplaceChild("TemplarLeggins", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition RightLeg2 = TemplarLeggins.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(48, 65).addBox(-2.5F, 5.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(28, 75)
				.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 107).addBox(-2.7F, 5.73F, -2.7F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));
		PartDefinition LeftLeg2 = TemplarLeggins.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(28, 65).addBox(-2.4F, 5.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(28, 85)
				.addBox(-2.4F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 107).addBox(-2.2F, 5.73F, -2.7F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

	}

}