// Date: 6/11/2012 3:12:45 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package twilightforest.client.model.entity;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;
import twilightforest.entity.EntityTFKobold;

public class ModelTFKobold<T extends EntityTFKobold> extends BipedModel<T> {
	//fields

	RendererModel rightear;
	RendererModel leftear;
	RendererModel snout;
	RendererModel jaw;

	boolean isJumping;

	public ModelTFKobold() {
		isJumping = false;

		textureWidth = 64;
		textureHeight = 32;

		bipedHead = new RendererModel(this, 0, 0);
		bipedHead.addBox(-3.5F, -7F, -3F, 7, 6, 6);
		bipedHead.setRotationPoint(0F, 13F, 0F);

		bipedBody = new RendererModel(this, 12, 19);
		bipedBody.addBox(0F, 0F, 0F, 7, 7, 4);
		bipedBody.setRotationPoint(-3.5F, 12F, -2F);

		bipedRightArm = new RendererModel(this, 36, 17);
		bipedRightArm.addBox(-3F, -1F, -1.5F, 3, 7, 3);
		bipedRightArm.setRotationPoint(-3.5F, 12F, 0F);

		bipedLeftArm.mirror = true;
		bipedLeftArm = new RendererModel(this, 36, 17);
		bipedLeftArm.addBox(0F, -1F, -1.5F, 3, 7, 3);
		bipedLeftArm.setRotationPoint(3.5F, 12F, 0F);

		bipedLeftArm.mirror = false;
		bipedRightLeg = new RendererModel(this, 0, 20);
		bipedRightLeg.addBox(-1.5F, 0F, -1.5F, 3, 5, 3);
		bipedRightLeg.setRotationPoint(-2F, 19F, 0F);

		bipedLeftLeg = new RendererModel(this, 0, 20);
		bipedLeftLeg.addBox(-1.5F, 0F, -1.5F, 3, 5, 3);
		bipedLeftLeg.setRotationPoint(2F, 19F, 0F);

		rightear = new RendererModel(this, 48, 20);
		rightear.addBox(0F, -4F, 0F, 4, 4, 1);
		rightear.setRotationPoint(3.5F, -3F, -1F);
		rightear.rotateAngleY = 0.2617994F;
		rightear.rotateAngleZ = -0.3490659F;

		bipedHead.addChild(rightear);

		leftear = new RendererModel(this, 48, 25);
		leftear.addBox(-4F, -4F, 0F, 4, 4, 1);
		leftear.setRotationPoint(-3.5F, -3F, -1F);
		leftear.rotateAngleY = -0.2617994F;
		leftear.rotateAngleZ = 0.3490659F;

		bipedHead.addChild(leftear);


		snout = new RendererModel(this, 28, 0);
		snout.addBox(-1.5F, -2F, -2F, 3, 2, 3);
		snout.setRotationPoint(0F, -2F, -3F);

		bipedHead.addChild(snout);

		jaw = new RendererModel(this, 28, 5);
		jaw.addBox(-1.5F, 0F, -2F, 3, 1, 3);
		jaw.setRotationPoint(0F, -2F, -3F);
		jaw.rotateAngleX = 0.20944F;

		bipedHead.addChild(jaw);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		this.bipedHead.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);
		this.bipedHead.rotateAngleX = headPitch / (180F / (float) Math.PI);

		this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.bipedRightArm.rotateAngleZ = 0.0F;
		this.bipedLeftArm.rotateAngleZ = 0.0F;

		this.bipedRightArm.rotateAngleX = -((float) Math.PI * .15F);
		this.bipedLeftArm.rotateAngleX = -((float) Math.PI * .15F);


		this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.bipedRightLeg.rotateAngleY = 0.0F;
		this.bipedLeftLeg.rotateAngleY = 0.0F;

		this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.19F) * 0.15F + 0.05F;
		this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.19F) * 0.15F + 0.05F;
		this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.267F) * 0.25F;
		this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.267F) * 0.25F;

		if (this.isJumping) {
			// open jaw
			this.jaw.rotateAngleX = 1.44F;
		} else {
			this.jaw.rotateAngleX = 0.20944F;
		}
	}

	@Override
	public void setLivingAnimations(T entity, float limbSwing, float limbSwingAmount, float partialTicks) {
		// check if entity is jumping
		this.isJumping = entity.getMotion().getY() > 0;
	}


	@Override
	public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		bipedHead.render(scale);
		bipedBody.render(scale);
		bipedRightArm.render(scale);
		bipedLeftArm.render(scale);
		bipedRightLeg.render(scale);
		bipedLeftLeg.render(scale);
	}
}
