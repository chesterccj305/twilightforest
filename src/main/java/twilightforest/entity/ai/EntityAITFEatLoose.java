package twilightforest.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import twilightforest.entity.passive.EntityTFQuestRam;

import java.util.List;

/**
 * This is an AI task for the quest ram.  When one of the items it wants comes within a close distance, i
 *
 * @author Ben
 */
public class EntityAITFEatLoose extends Goal {
	private final EntityTFQuestRam temptedQuestRam;
	private final Item temptID;

	private int delayTemptCounter;
	private EntityItem temptingItem;

	//TODO: Item to Ingredient
	public EntityAITFEatLoose(EntityTFQuestRam entityTFQuestRam, Item blockID) {
		this.temptedQuestRam = entityTFQuestRam;
		this.temptID = blockID;
		this.setMutexBits(0);
	}

	@Override
	public boolean shouldExecute() {
		if (this.delayTemptCounter > 0) {
			--this.delayTemptCounter;
			return false;
		} else {
			this.temptingItem = null;

			List<EntityItem> nearbyItems = this.temptedQuestRam.world.getEntitiesWithinAABB(EntityItem.class, this.temptedQuestRam.getBoundingBox().grow(2.0D, 2.0D, 2.0D));

			for (EntityItem itemNearby : nearbyItems) {
				DyeColor color = DyeColor.byMetadata(itemNearby.getItem().getItemDamage());
				if (itemNearby.getItem().getItem() == temptID && !temptedQuestRam.isColorPresent(color) && itemNearby.isAlive()) {
					this.temptingItem = itemNearby;
					break;
				}
			}

			return temptingItem != null;
		}
	}


	@Override
	public boolean shouldContinueExecuting() {
		return this.shouldExecute();
	}

	@Override
	public void startExecuting() {
	}

	@Override
	public void resetTask() {
		this.temptingItem = null;
		this.temptedQuestRam.getNavigator().clearPath();
		this.delayTemptCounter = 100;
	}

	@Override
	public void tick() {
		this.temptedQuestRam.getLookHelper().setLookPositionWithEntity(this.temptingItem, 30.0F, this.temptedQuestRam.getVerticalFaceSpeed());

		if (this.temptedQuestRam.getDistanceSq(this.temptingItem) < 6.25D) {
			DyeColor color = DyeColor.byMetadata(temptingItem.getItem().getItemDamage());
			if (!temptedQuestRam.isColorPresent(color)) { // we did technically already check this, but why not check again
				this.temptingItem.setDead();
				this.temptedQuestRam.playLivingSound();
				this.temptedQuestRam.setColorPresent(color);
				this.temptedQuestRam.animateAddColor(color, 50); // TODO: find a better place for this?  refactor?
			}
		}
	}

}
