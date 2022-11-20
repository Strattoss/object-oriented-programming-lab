package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GrassField extends AbstractWorldMap {
	final private Map<Vector2d, Grass> grasses = new HashMap<>();
	//final private ArrayList<Grass> grasses = new ArrayList<>();
	final private int grassNumber;

	/**
	 * Create a GrassField object of IWorldMap interface
	 *
	 * @param n How many grass patches you want to have on this GrassField
	 */
	public GrassField(int n) {
		grassNumber = n;
		spawnGrass(grassNumber);
	}

	/**
	 * Spawns n patches of grass on non-occupied tiles
	 *
	 * @param n number od patches of grass to generate
	 */
	private void spawnGrass(int n) {
		Vector2d randPosition;

		for (int i = 0; i < n; i++) {
			randPosition = randGrassPosition();
			while (this.isOccupied(randPosition)) {
				randPosition = randGrassPosition();
			}
			grasses.put(randPosition, new Grass(randPosition));
			//grasses.add(new Grass(randPosition));
		}
	}

	/**
	 * @return Random position for new patch of grass from surface [0,sqrt(10*grassNumber)] x [0,sqrt(10*grassNumber)]
	 */
	private Vector2d randGrassPosition() {
		return new Vector2d(
				(int) (Math.random() * (Math.sqrt(10 * grassNumber) + 1)),
				(int) (Math.random() * (Math.sqrt(10 * grassNumber) + 1))
		);
	}

	@Override
	public boolean noMapElementExists() {
		return super.noMapElementExists() && grasses.size() == 0;
	}

	@Override
	public Vector2d getBottomLeftCorner() {
		// taking first element
		Vector2d bottomLeft = animals.keySet().iterator().next();
		for (Vector2d position : animals.keySet()) {
			bottomLeft = bottomLeft.lowerLeft(position);
		}


		bottomLeft = (bottomLeft == null && grasses.size() > 0) ? grasses.get(0).getPosition() : bottomLeft;
		if (bottomLeft == null) return null;

		for (Animal animal : animals) {
			bottomLeft = animal.getPosition().lowerLeft(bottomLeft);
		}

		for (Grass grass : grasses) {
			bottomLeft = grass.getPosition().lowerLeft(bottomLeft);
		}

		return bottomLeft;
	}

	@Override
	public Vector2d getUpperRightCorner() {
		Vector2d upperRight = (animals.size() > 0) ? animals.get(0).getPosition() : null;
		upperRight = (upperRight == null && grasses.size() > 0) ? grasses.get(0).getPosition() : upperRight;
		if (upperRight == null) return null;

		for (Animal animal : animals) {
			upperRight = animal.getPosition().upperRight(upperRight);
		}

		for (Grass grass : grasses) {
			upperRight = grass.getPosition().upperRight(upperRight);
		}

		return upperRight;
	}

	@Override
	public Object objectAt(Vector2d position) {
		Object obj = super.objectAt(position);
		if (obj != null) {
			return obj;
		}

		for (Grass grass : grasses) {
			if (grass.getPosition().equals(position)) {
				return grass;
			}
		}

		return null;
	}

	@Override
	public void hasMovedTo(Vector2d position) {
		for (int i = 0; i < grasses.size(); i++) {
			if (grasses.get(i).getPosition().equals(position)) {
				grasses.remove(i);
				spawnGrass(1);
				break;
			}
		}
	}
}
