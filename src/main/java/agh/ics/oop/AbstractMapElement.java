package agh.ics.oop;

import agh.ics.oop.gui.GuiElementBox;

public abstract class AbstractMapElement implements IMapElement{
    IWorldMap map;
    Vector2d position;
    GuiElementBox gui;

    public Vector2d getPosition() {
        return this.position;
    }

    public GuiElementBox getGui() {return gui;}

}
