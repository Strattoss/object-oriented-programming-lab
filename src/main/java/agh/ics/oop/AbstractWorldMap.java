package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
	final Map<Vector2d, Animal> animals = new HashMap<>();
	final public MapBoundary mapBoundary = new MapBoundary();

	public boolean canMoveTo(Vector2d position) {
		return animals.get(position) == null;
	}

	public boolean place(Animal animal) {
		if (canMoveTo(animal.getPosition())) {
			animals.put(animal.getPosition(), animal);
			hasMovedTo(animal.getPosition());
			return true;
		}

		else throw new IllegalArgumentException("Cannot place animal on position " + animal.getPosition());
	}

	/**
	 * An Animal has changed position, so he notified this map
	 * @param oldPosition the position the object left
	 * @param newPosition the position the object moved to
	 */
	public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
		Animal animal = animals.get(oldPosition);
		animals.remove(oldPosition);
		animals.put(newPosition, animal);
		mapBoundary.positionChanged(oldPosition, newPosition);
		hasMovedTo(newPosition);
	}

	/**
	 * An object has just moved to this position, so do, check and update what is necessary
	 *
	 * @param position The position an object moved to
	 */
	public abstract void hasMovedTo(Vector2d position);

	public boolean isOccupied(Vector2d position) {
		return objectAt(position) != null;
	}

	public Object objectAt(Vector2d position) {
		return animals.get(position);
	}



	public String toString() {
		MapVisualizer mapVisualizer = new MapVisualizer(this);
		if (noMapElementExists()) {
			return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(0, 0));
		} else {
			return mapVisualizer.draw(mapBoundary.getBottomLeftCorner(), mapBoundary.getUpperRightCorner());
		}
	}

	public boolean noMapElementExists() {
		return animals.size() == 0;
	}

	public Vector2d getBottomLeftCorner() {
		return mapBoundary.getBottomLeftCorner();
	}

	public Vector2d getUpperRightCorner() {
		return mapBoundary.getUpperRightCorner();
	}
}
