package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {

	RectangularMap map;

	@Test
	public void canMoveToTest() {
		map = new RectangularMap(3, 6);
		new Animal(map, new Vector2d(2, 2));
		Vector2d[] vectors = {new Vector2d(0, 0), new Vector2d(0, -1), new Vector2d(3, 6), new Vector2d(4, 6), new Vector2d(2, 2)};
		boolean[] bools = {true, false, true, false, false};

		for (int i = 0; i < vectors.length; i++) {
			if (bools[i]) {
				Assertions.assertTrue(map.canMoveTo(vectors[i]));
			} else {
				Assertions.assertFalse(map.canMoveTo(vectors[i]));
			}
		}
	}

	@Test
	public void placeTest() {
		map = new RectangularMap(3, 6);
		// should be placed correctly
		Animal dog = new Animal(map, new Vector2d(0, 0));
		Animal pig = new Animal(map, new Vector2d(3, 6));

		Assertions.assertEquals(dog, map.objectAt(new Vector2d(0, 0)));
		Assertions.assertEquals(pig, map.objectAt(new Vector2d(3, 6)));

		//shouldn't be placed correctly
		Animal cow = new Animal(map, new Vector2d(3, 6));
		Assertions.assertNull(cow.map);
		Animal hen = new Animal(map, new Vector2d(4, 6));
		Assertions.assertNull(hen.map);
	}

	@Test
	public void objectAtTest() {
		map = new RectangularMap(3, 6);
		// should be placed correctly
		new Animal(map, new Vector2d(0, 0));
		new Animal(map, new Vector2d(3, 6));
		new Animal(map, new Vector2d(2, 4));
		new Animal(map, new Vector2d(0, 6));

		Assertions.assertNotNull(map.objectAt(new Vector2d(0, 0)));
		Assertions.assertNotNull(map.objectAt(new Vector2d(3, 6)));
		Assertions.assertNotNull(map.objectAt(new Vector2d(2, 4)));
		Assertions.assertNotNull(map.objectAt(new Vector2d(0, 6)));

		Assertions.assertNull(map.objectAt(new Vector2d(0, 1)));
		Assertions.assertNull(map.objectAt(new Vector2d(1, 0)));
		Assertions.assertNull(map.objectAt(new Vector2d(10, 10)));
		Assertions.assertNull(map.objectAt(new Vector2d(3, 0)));
	}

	@Test
	public void isOccupiedTest() {
		map = new RectangularMap(3, 6);
		// should be placed correctly
		new Animal(map, new Vector2d(0, 0));
		new Animal(map, new Vector2d(3, 6));
		new Animal(map, new Vector2d(2, 4));
		new Animal(map, new Vector2d(0, 6));

		Assertions.assertTrue(map.isOccupied(new Vector2d(0, 0)));
		Assertions.assertTrue(map.isOccupied(new Vector2d(3, 6)));
		Assertions.assertTrue(map.isOccupied(new Vector2d(2, 4)));
		Assertions.assertTrue(map.isOccupied(new Vector2d(0, 6)));

		Assertions.assertFalse(map.isOccupied(new Vector2d(0, 1)));
		Assertions.assertFalse(map.isOccupied(new Vector2d(1, 0)));
		Assertions.assertFalse(map.isOccupied(new Vector2d(10, 10)));
		Assertions.assertFalse(map.isOccupied(new Vector2d(3, 0)));
	}
}
