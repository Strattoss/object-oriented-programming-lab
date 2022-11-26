package agh.ics.oop;

import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    final private TreeSet<Vector2d> mapElementsByX= new TreeSet<>(new Vector2DComparatorByX());
    final private TreeSet<Vector2d> mapElementsByY= new TreeSet<>(new Vector2DComparatorByY());

    public void add(Vector2d position) {
        mapElementsByX.add(position);
        mapElementsByY.add(position);
    }

    public void remove(Vector2d position) {
        mapElementsByX.remove(position);
        mapElementsByY.remove(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        remove(oldPosition);
        add(newPosition);
    }

    public Vector2d getUpperRightCorner() {
        return mapElementsByX.isEmpty() ?
                new Vector2d(0, 0) :
                new Vector2d(mapElementsByX.last().x, mapElementsByY.last().y);
    }

    public Vector2d getBottomLeftCorner() {
        return mapElementsByX.isEmpty() ?
                new Vector2d(0, 0) :
                new Vector2d(mapElementsByX.first().x, mapElementsByY.first().y);
    }
}
