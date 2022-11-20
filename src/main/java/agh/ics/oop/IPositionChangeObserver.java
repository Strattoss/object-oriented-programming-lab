package agh.ics.oop;

public interface IPositionChangeObserver {
	/**
	 * This method receives information from objects, that changed their position.
	 * @param oldPosition the position the object left
	 * @param newPosition the position the object moved to
	 */
	void positionChanged(Vector2d oldPosition, Vector2d newPosition);
}
