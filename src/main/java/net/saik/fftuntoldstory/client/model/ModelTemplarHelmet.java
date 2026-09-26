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
public class ModelTemplarHelmet extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("fft_untold_story", "model_templar_helmet"), "main");
	public final ModelPart TemplarHelmet;

	public ModelTemplarHelmet(ModelPart root) {
		super(root);
		this.TemplarHelmet = root.getChild("TemplarHelmet");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition TemplarHelmet = partdefinition.addOrReplaceChild("TemplarHelmet",
				CubeListBuilder.create().texOffs(64, 15).addBox(-4.5F, -10.5F, -4.5F, 9.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(93, 6).addBox(-4.05F, -6.75F, -4.4F, 8.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(84, 43)
						.addBox(3.5F, -5.5F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(100, 15).addBox(-3.5F, -5.75F, 1.45F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(64, 43)
						.addBox(-4.5F, -5.5F, -4.5F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = TemplarHelmet.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(90, 29).addBox(-2.5F, -2.5F, -5.0F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.25F, -2.25F, 0.5F, 0.0F, 0.0F, 0.0436F));
		PartDefinition cube_r2 = TemplarHelmet.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(64, 29).addBox(-1.5F, -2.5F, -5.0F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.25F, -2.25F, 0.5F, 0.0F, 0.0F, -0.0436F));
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