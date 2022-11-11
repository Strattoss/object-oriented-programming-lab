package agh.ics.oop;

import java.util.ArrayList;

public class GrassField implements IWorldMap {
    private final ArrayList<Animal> animals = new ArrayList<>();
    private final ArrayList<Grass> grasses = new ArrayList<>();

    /**
     * Create a GrassField object of IWorldMap interface
     * @param n
     * How many grass patches you want to have
     */
    public GrassField(int n) {
        Vector2d randPosition;
        for (int i=0; i<n; i++) {
            randPosition = new Vector2d(randInt(n), randInt(n));
            while (this.isOccupied(randPosition)) {
                randPosition = new Vector2d(randInt(n), randInt(n));
            }
            grasses.add(new Grass(randPosition));
        }
    }


    private boolean anyMapElementExists() {
        return animals.size() > 0 || grasses.size() > 0;
    }

    private Vector2d findBottomLeftMapElement() {
        Vector2d bottomLeft = (animals.size()>0) ? animals.get(0).getPosition() : null;
        bottomLeft = (bottomLeft == null && grasses.size()>0) ? grasses.get(0).getPosition() : bottomLeft;
        if (bottomLeft == null) return null;

        for (Animal animal : animals) {
            bottomLeft = animal.getPosition().lowerLeft(bottomLeft);
        }

        for (Grass grass : grasses) {
            bottomLeft = grass.getPosition().lowerLeft(bottomLeft);
        }

        return bottomLeft;
    }

    private Vector2d findUpperRightMapElement() {
        Vector2d upperRight = (animals.size()>0) ? animals.get(0).getPosition() : null;
        upperRight = (upperRight == null && grasses.size()>0) ? grasses.get(0).getPosition() : upperRight;
        if (upperRight == null) return null;

        for (Animal animal : animals) {
            upperRight = animal.getPosition().upperRight(upperRight);
        }

        for (Grass grass : grasses) {
            upperRight = grass.getPosition().upperRight(upperRight);
        }

        return upperRight;
    }

    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        if (!anyMapElementExists()) {
            return mapVisualizer.draw(new Vector2d(0,0), new Vector2d(0,0));
        }
        else {
            return mapVisualizer.draw(findBottomLeftMapElement(), findUpperRightMapElement());
        }
    }

    private int randInt(int n) {
        return (int) (Math.random() * (Math.sqrt(10 * n)+1));
    }

    public boolean canMoveTo(Vector2d position) {
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
        return objectAt(position) != null;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }

        for (Grass grass : grasses) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }

        return null;
    }
}
