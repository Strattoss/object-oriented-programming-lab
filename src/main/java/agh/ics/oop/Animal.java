package agh.ics.oop;

import java.util.HashSet;
import java.util.Set;

public class Animal {
	final IWorldMap map;
	private MapDirection orientation;
	private Vector2d position;
	private final Set<IPositionChangeObserver> observers = new HashSet<>();

	public Animal(IWorldMap map, Vector2d initialPosition) {
		orientation = MapDirection.NORTH;
		position = initialPosition;
		// if map cannot place this animal, then this animal cannot be assigned to any map, hence this.map = null
		this.map = map.place(this) ? map : null;
        /*if (this.map == null) {
            throw new ExceptionInInitializerError("The animal couldn't be placed on position: "+position+", on the following map: \n"+map);
        }*/
		if (this.map != null) {
			addObserver((IPositionChangeObserver) map);
		}
	}

	public Animal(IWorldMap map) {
		this(map, new Vector2d(0, 0));
	}

	public String toString() {
		return orientation.toString();
	}

	public Vector2d getPosition() {
		return this.position;
	}

	public boolean isAt(Vector2d position) {
		return this.position.equals(position);
	}

	private void addObserver(IPositionChangeObserver observer) {
		observers.add(observer);
	}

	private void removeObserver(IPositionChangeObserver observer) {
		observers.remove(observer);
	}

	private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
		for (IPositionChangeObserver observer : observers) {
			observer.positionChanged(oldPosition, newPosition);
		}
	}

	public void move(MoveDirection direction) {
		Vector2d endingPosition;
		Vector2d startingPosition = this.position;
		switch (direction) {
			case RIGHT -> this.orientation = this.orientation.next();

			case LEFT -> this.orientation = this.orientation.previous();

			case FORWARD -> {
				endingPosition = this.position.add(orientation.toUnitVector());
				if (map.canMoveTo(endingPosition)) {
					this.position = endingPosition;
					positionChanged(startingPosition, endingPosition);
				}
			}

			case BACKWARD -> {
				endingPosition = this.position.add(orientation.toUnitVector().opposite());
				if (map.canMoveTo(endingPosition)) {
					this.position = endingPosition;
					positionChanged(startingPosition, endingPosition);
				}
			}
		}
	}
}
