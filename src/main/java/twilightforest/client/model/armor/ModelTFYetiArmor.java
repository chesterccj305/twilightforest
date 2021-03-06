package twilightforest.client.model.armor;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class ModelTFYetiArmor extends ModelTFArmor {

	private final EquipmentSlotType slot;

	private RendererModel bipedLegBody;
	private RendererModel rightRuff;
	private RendererModel leftRuff;
	private RendererModel rightToe;
	private RendererModel leftToe;

	public ModelTFYetiArmor(EquipmentSlotType slot, float expand) {
		super(expand);
		this.slot = slot;

		//bigger head
		this.bipedHead = new RendererModel(this, 0, 0);
		this.bipedHead.addBox(-4.5F, -7.5F, -4.0F, 9, 8, 8, expand);
		this.bipedHead.setRotationPoint(0.0F, 0.0F + expand, 0.0F);

		// add horns
		addPairHorns(-8.0F, 35F);
		addPairHorns(-6.0F, 15F);
		addPairHorns(-4.0F, -5F);


		// change leg texture
		this.bipedRightLeg = new RendererModel(this, 40, 0);
		this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, expand);
		this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F + 0.0F, 0.0F);

		this.bipedLeftLeg = new RendererModel(this, 40, 0);
		this.bipedLeftLeg.mirror = true;
		this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, expand);
		this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F + 0.0F, 0.0F);

		this.rightRuff = new RendererModel(this, 40, 22);
		this.rightRuff.addBox(-2.5F, 0.0F, -2.5F, 5, 2, 5, expand);
		this.rightRuff.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.bipedRightLeg.addChild(rightRuff);

		this.leftRuff = new RendererModel(this, 40, 22);
		this.leftRuff.addBox(-2.5F, 0.0F, -2.5F, 5, 2, 5, expand);
		this.leftRuff.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.bipedLeftLeg.addChild(leftRuff);

		this.rightToe = new RendererModel(this, 40, 17);
		this.rightToe.addBox(-2.0F, 0.0F, -1.0F, 4, 2, 1, expand);
		this.rightToe.setRotationPoint(0.0F, 10.0F, -2.0F);
		this.bipedRightLeg.addChild(rightToe);

		this.leftToe = new RendererModel(this, 40, 17);
		this.leftToe.addBox(-2.0F, 0.0F, -1.0F, 4, 2, 1, expand);
		this.leftToe.setRotationPoint(0.0F, 10.0F, -2.0F);
		this.bipedLeftLeg.addChild(leftToe);

		// stuff for chest and legs
		this.bipedBody = new RendererModel(this, 0, 0);
		this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 11, 4, expand);
		this.bipedBody.setRotationPoint(0.0F, 0.0F + 0.0f, 0.0F);

		this.bipedLegBody = new RendererModel(this, 40, 16);
		this.bipedLegBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, expand);
		this.bipedLegBody.setRotationPoint(0.0F, 0.0F + 0.0f, 0.0F);

		this.bipedRightArm = new RendererModel(this, 0, 16);
		this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 10, 4, expand);
		this.bipedRightArm.setRotationPoint(-5.0F, 2.0F + 0.0f, 0.0F);

		this.bipedLeftArm = new RendererModel(this, 0, 16);
		this.bipedLeftArm.mirror = true;
		this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 10, 4, expand);
		this.bipedLeftArm.setRotationPoint(5.0F, 2.0F + 0.0f, 0.0F);

	}

	private void addPairHorns(float height, float zangle) {
		RendererModel horn1a;
		RendererModel horn1b;

		horn1a = new RendererModel(this, 0, 19);
		horn1a.addBox(-3.0F, -1.5F, -1.5F, 3, 3, 3);
		horn1a.setRotationPoint(-4.5F, height, -1.0F);
		horn1a.rotateAngleY = -30F / (180F / (float) Math.PI);
		horn1a.rotateAngleZ = zangle / (180F / (float) Math.PI);
		this.bipedHead.addChild(horn1a);

		horn1b = new RendererModel(this, 0, 26);
		horn1b.addBox(-4.0F, -1.0F, -1.0F, 5, 2, 2);
		horn1b.setRotationPoint(-3.0F, 0.0F, 0.0F);
		horn1b.rotateAngleY = -20F / (180F / (float) Math.PI);
		horn1b.rotateAngleZ = zangle / (180F / (float) Math.PI);
		horn1a.addChild(horn1b);

		RendererModel horn2a;
		RendererModel horn2b;

		horn2a = new RendererModel(this, 0, 19);
		horn2a.addBox(0.0F, -1.5F, -1.5F, 3, 3, 3);
		horn2a.setRotationPoint(4.5F, height, -1.0F);
		horn2a.rotateAngleY = 30F / (180F / (float) Math.PI);
		horn2a.rotateAngleZ = -zangle / (180F / (float) Math.PI);
		this.bipedHead.addChild(horn2a);

		horn2b = new RendererModel(this, 0, 26);
		horn2b.addBox(-1.0F, -1.0F, -1.0F, 5, 2, 2);
		horn2b.setRotationPoint(3.0F, 0.0F, 0.0F);
		horn2b.rotateAngleY = 20F / (180F / (float) Math.PI);
		horn2b.rotateAngleZ = -zangle / (180F / (float) Math.PI);
		horn2a.addChild(horn2b);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		bipedLegBody.showModel = visible;
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		switch (slot) {
			case HEAD:
				this.bipedHead.showModel = true;
				this.bipedHeadwear.showModel = false;
				this.bipedBody.showModel = false;
				this.bipedRightArm.showModel = false;
				this.bipedLeftArm.showModel = false;
				this.bipedLegBody.showModel = false;
				this.bipedRightLeg.showModel = false;
				this.bipedLeftLeg.showModel = false;
				break;
			case CHEST:
				this.bipedHead.showModel = false;
				this.bipedHeadwear.showModel = false;
				this.bipedBody.showModel = true;
				this.bipedRightArm.showModel = true;
				this.bipedLeftArm.showModel = true;
				this.bipedLegBody.showModel = false;
				this.bipedRightLeg.showModel = false;
				this.bipedLeftLeg.showModel = false;
				break;
			case LEGS:
				this.bipedHead.showModel = false;
				this.bipedHeadwear.showModel = false;
				this.bipedBody.showModel = false;
				this.bipedRightArm.showModel = false;
				this.bipedLeftArm.showModel = false;
				this.bipedLegBody.showModel = true;
				this.bipedRightLeg.showModel = true;
				this.bipedLeftLeg.showModel = true;
				this.leftRuff.showModel = false;
				this.leftToe.showModel = false;
				this.rightRuff.showModel = false;
				this.rightToe.showModel = false;
				break;
			case FEET:
				this.bipedHead.showModel = false;
				this.bipedHeadwear.showModel = false;
				this.bipedBody.showModel = false;
				this.bipedRightArm.showModel = false;
				this.bipedLeftArm.showModel = false;
				this.bipedLegBody.showModel = false;
				this.bipedRightLeg.showModel = true;
				this.bipedLeftLeg.showModel = true;
				this.leftRuff.showModel = true;
				this.leftToe.showModel = true;
				this.rightRuff.showModel = true;
				this.rightToe.showModel = true;
				break;
			default:
				break;
		}
		super.render((LivingEntity) entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.bipedLegBody.render(scale);
	}
}
