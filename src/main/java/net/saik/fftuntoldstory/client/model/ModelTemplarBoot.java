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
public class ModelTemplarBoot extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("fft_untold_story", "model_templar_boot"), "main");
	public final ModelPart TemplarBoots;
	public final ModelPart leftBoot;
	public final ModelPart rightBoot;

	public ModelTemplarBoot(ModelPart root) {
		super(root);
		this.TemplarBoots = root.getChild("TemplarBoots");
		this.leftBoot = this.TemplarBoots.getChild("leftBoot");
		this.rightBoot = this.TemplarBoots.getChild("rightBoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition TemplarBoots = partdefinition.addOrReplaceChild("TemplarBoots", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition leftBoot = TemplarBoots.addOrReplaceChild("leftBoot", CubeListBuilder.create().texOffs(0, 71).addBox(-2.25F, 9.75F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));
		PartDefinition rightBoot = TemplarBoots.addOrReplaceChild("rightBoot", CubeListBuilder.create().texOffs(0, 80).addBox(-2.75F, 9.75F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));
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