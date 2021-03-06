package twilightforest.structures.stronghold;

import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import twilightforest.TFFeature;

import java.util.List;
import java.util.Random;

public class ComponentTFStrongholdUpperTIntersection extends StructureTFStrongholdComponent {

	public ComponentTFStrongholdUpperTIntersection() {
	}

	public ComponentTFStrongholdUpperTIntersection(TFFeature feature, int i, Direction facing, int x, int y, int z) {
		super(feature, i, facing, x, y, z);
	}

	@Override
	public MutableBoundingBox generateBoundingBox(Direction facing, int x, int y, int z) {
		return MutableBoundingBox.getComponentToAddBoundingBox(x, y, z, -2, -1, 0, 5, 5, 5, facing);
	}

	@Override
	public void buildComponent(StructurePiece parent, List<StructurePiece> list, Random random) {
		super.buildComponent(parent, list, random);

		// make a random component to the left
		addNewUpperComponent(parent, list, random, Rotation.COUNTERCLOCKWISE_90, 5, 1, 2);

		// make a random component to the right
		addNewUpperComponent(parent, list, random, Rotation.CLOCKWISE_90, -1, 1, 2);
	}

	@Override
	public boolean addComponentParts(IWorld world, Random rand, MutableBoundingBox sbb, ChunkPos chunkPosIn) {
		if (this.isLiquidInStructureBoundingBox(world, sbb)) {
			return false;
		} else {
			placeUpperStrongholdWalls(world.getWorld(), sbb, 0, 0, 0, 4, 4, 4, rand, deco.randomBlocks);

			// entrance doorway
			placeSmallDoorwayAt(world.getWorld(), rand, 2, 2, 1, 0, sbb);

			// left turn doorway
			placeSmallDoorwayAt(world.getWorld(), rand, 3, 4, 1, 2, sbb);

			// right turn doorway
			placeSmallDoorwayAt(world.getWorld(), rand, 1, 0, 1, 2, sbb);

			return true;
		}
	}

	@Override
	public boolean isComponentProtected() {
		return false;
	}
}
