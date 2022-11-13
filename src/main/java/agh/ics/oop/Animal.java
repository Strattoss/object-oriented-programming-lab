package agh.ics.oop;

public class Animal {
	final IWorldMap map;
	private MapDirection orientation;
	private Vector2d position;

	public Animal(IWorldMap map, Vector2d initialPosition) {
		orientation = MapDirection.NORTH;
		position = initialPosition;
		// if map cannot place this animal, then this animal cannot be assigned to any map, hence this.map = null
		this.map = map.place(this) ? map : null;
        /*if (this.map == null) {
            throw new ExceptionInInitializerError("The animal couldn't be placed on position: "+position+", on the following map: \n"+map);
        }*/
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

	public void move(MoveDirection direction) {
		Vector2d endingPosition;
		switch (direction) {
			case RIGHT -> this.orientation = this.orientation.next();
			case LEFT -> this.orientation = this.orientation.previous();
			case FORWARD -> {
				endingPosition = this.position.add(orientation.toUnitVector());
				if (map.canMoveTo(endingPosition)) {
					this.position = endingPosition;
					((AbstractWorldMap) map).hasMovedTo(endingPosition);
				}
			}
			case BACKWARD -> {
				endingPosition = this.position.add(orientation.toUnitVector().opposite());
				if (map.canMoveTo(endingPosition)) {
					this.position = endingPosition;
					((AbstractWorldMap) map).hasMovedTo(endingPosition);
				}
			}
		}
	}
}
