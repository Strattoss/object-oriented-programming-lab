package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MapDirectionTest {

    @Test
    public void toStringTest() {
        Assertions.assertEquals("N", MapDirection.NORTH.toString());
        Assertions.assertEquals("E", MapDirection.EAST.toString());
        Assertions.assertEquals("S", MapDirection.SOUTH.toString());
        Assertions.assertEquals("W", MapDirection.WEST.toString());
    }

    @Test
    public void nextTest() {
        MapDirection md = MapDirection.NORTH;
        Assertions.assertEquals(MapDirection.EAST, md.next());
        md = md.next();
        Assertions.assertEquals(MapDirection.SOUTH, md.next());
        md = md.next();
        Assertions.assertEquals(MapDirection.WEST, md.next());
        md = md.next();
        Assertions.assertEquals(MapDirection.NORTH, md.next());
    }

    @Test
    public void previousTest() {
        MapDirection md = MapDirection.NORTH;
        Assertions.assertEquals(MapDirection.WEST, md.previous());
        md = md.previous();
        Assertions.assertEquals(MapDirection.SOUTH, md.previous());
        md = md.previous();
        Assertions.assertEquals(MapDirection.EAST, md.previous());
        md = md.previous();
        Assertions.assertEquals(MapDirection.NORTH, md.previous());
    }
}
