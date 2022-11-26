package agh.ics.oop;

import java.util.Comparator;

public abstract class AbstractMapElement {
    IWorldMap map;
    Vector2d position;

    public Vector2d getPosition() {
        return this.position;
    }
}
