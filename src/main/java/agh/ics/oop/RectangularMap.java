package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
	final Vector2d bottomLeftCorner;
	final Vector2d upperRightCorner;

	public RectangularMap(int width, int height) {
		bottomLeftCorner = new Vector2d(0, 0);
		upperRightCorner = new Vector2d(width, height);
	}

	@Override
	public Vector2d getBottomLeftCorner() {
		return bottomLeftCorner;
	}

	@Override
	public Vector2d getUpperRightCorner() {
		return upperRightCorner;
	}

	@Override
	public boolean canMoveTo(Vector2d position) {
		return super.canMoveTo(position) && position.follows(bottomLeftCorner) && position.precedes(upperRightCorner);
	}

	@Override
	public void hasMovedTo(Vector2d position) {
    }

}
