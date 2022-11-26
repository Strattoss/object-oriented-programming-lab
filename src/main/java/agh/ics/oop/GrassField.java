package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
	final private Map<Vector2d, Grass> grasses = new HashMap<>();
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
			grasses.put(randPosition, new Grass(this, randPosition));
			mapBoundary.add(randPosition);
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
	public Object objectAt(Vector2d position) {
		Object obj = super.objectAt(position);
		if (obj != null) {
			return obj;
		}

		for (Grass grass : grasses.values()) {
			if (grass.getPosition().equals(position)) {
				return grass;
			}
		}

		return null;
	}

	@Override
	public void hasMovedTo(Vector2d position) {
		if (grasses.containsKey(position)) {
			grasses.remove(position);
			mapBoundary.remove(position);
			spawnGrass(1);
		}
	}
}
