package agh.ics.oop;

public class Grass extends AbstractMapElement {

	public Grass(IWorldMap map, Vector2d position) {
		this.map = map;
		this.position = position;
	}

	public String toString() {
		return "*";
	}

	@Override
	public String getImgURL() {
		return "src/main/resources/grass.png";
	}
}
