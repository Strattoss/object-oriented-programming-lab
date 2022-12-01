package agh.ics.oop;

public interface IMapElement {
    IWorldMap map = null;
    Vector2d position = null;
    abstract public Vector2d getPosition ();

    abstract public String getImgURL();
}
