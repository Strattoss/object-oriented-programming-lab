package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {
    GrassField map;

    @Test
    public void canMoveToTest() {
        map = new GrassField(10);
        new Animal(map, new Vector2d(2, 2));
        Vector2d[] vectors = {new Vector2d(0, 0), new Vector2d(0, -1), new Vector2d(3, 6), new Vector2d(4, 6), new Vector2d(2,2)};
        boolean[] bools = {true, true, true, true, false};

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
        map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(0, 0),new Vector2d(3, 6), new Vector2d(3, 6), new Vector2d(-1000, -1000)};
        boolean[] bools = {true, true, false, true};

        Animal animal;
        // we can place animals on tiles with grass, so we don't check if grass is already on the tile
        for (int i = 0; i < positions.length; i++) {
            animal = new Animal(map, positions[i]);
            if (bools[i]) {
                Assertions.assertNotNull(animal.map);
            } else {
                Assertions.assertNull(animal.map);
            }
        }
    }

    @Test
    public void objectAtTest() {
        map = new GrassField(10);
        Animal animal;
        Vector2d[] animal_positions = {new Vector2d(0, 0),new Vector2d(3, 6), new Vector2d(-1000, -1000)};

        for (Vector2d position : animal_positions) {
            animal = new Animal(map, position);
            Assertions.assertSame(map.objectAt(position), animal);
        }

        // these tiles have to be empty (grass cannot appear there and I didn't place any animals on these tiles)
        Vector2d[] empty_positions = {new Vector2d(-1, 0), new Vector2d(-500, -500)};
        for (Vector2d position : empty_positions) {
            Assertions.assertNull(map.objectAt(position));
        }
    }

    @Test
    public void isOccupiedTest() {
        map = new GrassField(10);
        // should be placed correctly
        new Animal(map, new Vector2d(0, 0));
        new Animal(map, new Vector2d(3, 6));
        new Animal(map, new Vector2d(2, 4));
        new Animal(map, new Vector2d(0, 6));

        Assertions.assertTrue(map.isOccupied(new Vector2d(0,0)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(3,6)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(2,4)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(0,6)));
    }
}
