package agh.ics.oop;

import agh.ics.oop.gui.GuiElementBox;

public class Grass extends AbstractMapElement {

	public Grass(IWorldMap map, Vector2d position) {
		this.map = map;
		this.position = position;
		this.gui = new GuiElementBox(this);
	}

	public String toString() {
		return "*";
	}

	@Override
	public String getImgURL() {
		return "file:src/main/resources/grass.png";
	}
}
