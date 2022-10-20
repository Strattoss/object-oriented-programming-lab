package agh.ics.oop;

import java.util.Vector;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    final private Vector2d bottomLeftCorner = new Vector2d(0, 0);
    final private Vector2d upperRightCorner = new Vector2d(4, 4);

    public Animal() {
        orientation = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }

    public String toString() {
        return "Animal position: "+position.toString()+", orientation: "+orientation.toString();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        Vector2d endingPosition;
        switch (direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD, BACKWARD:
                endingPosition = this.position.add(orientation.toUnitVector());
                if (endingPosition.follows(bottomLeftCorner) && endingPosition.precedes(upperRightCorner)) {
                    this.position = endingPosition;
                }
                break;
        }
    }

}
