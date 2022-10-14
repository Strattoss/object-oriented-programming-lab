package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MapDirectionTest {

    @Test
    public void toStringTest() {
        Assertions.assertEquals("Północ", MapDirection.NORTH.toString());
        Assertions.assertEquals("Wschód", MapDirection.EAST.toString());
        Assertions.assertEquals("Południe", MapDirection.SOUTH.toString());
        Assertions.assertEquals("Zachód", MapDirection.WEST.toString());
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
