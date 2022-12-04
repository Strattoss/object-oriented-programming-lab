package agh.ics.oop;

import agh.ics.oop.gui.GuiElementBox;

import java.util.HashSet;
import java.util.Set;

public class Animal extends AbstractMapElement {

	private MapDirection orientation;

	private final Set<IPositionChangeObserver> observers = new HashSet<>();

	public Animal(IWorldMap map, Vector2d initialPosition) {
		orientation = MapDirection.NORTH;
		position = initialPosition;
		this.map = map;
		map.place(this);

		gui = new GuiElementBox(this);

		addObserver(gui);
		addObserver((IPositionChangeObserver) this.map);
	}

	public Animal(IWorldMap map) {
		this(map, new Vector2d(0, 0));
	}

	public String toString() {
		return orientation.toString();
	}

	public boolean isAt(Vector2d position) {
		return this.position.equals(position);
	}

	@Override
	public String getImgURL() {
		return switch (this.orientation) {
			case NORTH -> "file:src/main/resources/up.png";
			case EAST -> "file:src/main/resources/right.png";
			case SOUTH -> "file:src/main/resources/down.png";
			case WEST -> "file:src/main/resources/left.png";
		};
	}

	public void addObserver(IPositionChangeObserver observer) {
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
			case RIGHT -> {
				this.orientation = this.orientation.next();
				positionChanged(startingPosition, startingPosition);}

			case LEFT -> {
				this.orientation = this.orientation.previous();
				positionChanged(startingPosition, startingPosition);}

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
