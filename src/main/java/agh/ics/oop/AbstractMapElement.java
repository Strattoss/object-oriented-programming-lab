package agh.ics.oop;

import java.util.Comparator;

public abstract class AbstractMapElement implements IMapElement{
    IWorldMap map;
    Vector2d position;

    public Vector2d getPosition() {
        return this.position;
    }

}
