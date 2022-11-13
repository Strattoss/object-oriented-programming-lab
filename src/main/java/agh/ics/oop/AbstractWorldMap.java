package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap {
	final ArrayList<Animal> animals = new ArrayList<>();

	public boolean canMoveTo(Vector2d position) {
		for (Animal animal : animals) {
			if (animal.getPosition().equals(position)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * An object has just moved to this position, so do what is necessary
	 *
	 * @param position The position an object moved to
	 */
	public abstract void hasMovedTo(Vector2d position);

	public boolean place(Animal animal) {
		if (canMoveTo(animal.getPosition())) {
			animals.add(animal);
			hasMovedTo(animal.getPosition());
			return true;
		} else return false;
	}

	public boolean isOccupied(Vector2d position) {
		return objectAt(position) != null;
	}

	public Object objectAt(Vector2d position) {
		for (Animal animal : animals) {
			if (animal.getPosition().equals(position)) {
				return animal;
			}
		}
		return null;
	}

	public String toString() {
		MapVisualizer mapVisualizer = new MapVisualizer(this);
		if (noMapElementExists()) {
			return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(0, 0));
		} else {
			return mapVisualizer.draw(getBottomLeftCorner(), getUpperRightCorner());
		}
	}

	public boolean noMapElementExists() {
		return animals.size() == 0;
	}

	public abstract Vector2d getBottomLeftCorner();

	public abstract Vector2d getUpperRightCorner();
}
