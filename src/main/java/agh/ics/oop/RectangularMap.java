package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {
    final Vector2d bottomLeftCorner;
    final Vector2d upperRightCorner;
    private final ArrayList<Animal> animals = new ArrayList<>();


    public RectangularMap(int width, int height) {
        bottomLeftCorner = new Vector2d(0, 0);
        upperRightCorner = new Vector2d(width, height);
    }

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(bottomLeftCorner, upperRightCorner);
    }

    public boolean canMoveTo(Vector2d position) {
        if (!position.follows(bottomLeftCorner) || !position.precedes(upperRightCorner)) {
            return false;
        }
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return false;
            }
        }
        return true;
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        else return false;
    }

     public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
    }
}
