package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Vector2dTest {

    final int[] x_values1 = {1, 1, 3, 0, 30, -4};
    final int[] y_values1 = {1, 2, -4, 0, -30, -6};
    final int[] x_values2 = {1, 2, 5, 0, 1000, -2000};
    final int[] y_values2 = {1, 2, 6, 0, 1000, -3000};
    final boolean[] equals = {true, false, false, true, false, false};

    // contains Vectors2d like (x_values1, y_values1) and (x_values2, y_values2)
    final String[] toString = {"(1,1)", "(1,1)", "(1,2)", "(2,2)", "(3,-4)", "(5,6)", "(0,0)", "(0,0)", "(30,-30)", "(1000,1000)", "(-4,-6)", "(-2000,-3000)"};
    final boolean[] precedes = {true, true, true, true, true, false};
    final boolean[] follows = {true, false, false, true, false, true};
    final String[] upperRight = {"(1,1)", "(2,2)", "(5,6)", "(0,0)", "(1000,1000)", "(-4,-6)"};
    final String[] lowerLeft = {"(1,1)", "(1,2)", "(3,-4)", "(0,0)", "(30,-30)", "(-2000,-3000)"};
    final String[] add = {"(2,2)", "(3,4)", "(8,2)", "(0,0)", "(1030,970)", "(-2004,-3006)"};
    final String[] subtract = {"(0,0)", "(-1,0)", "(-2,-10)", "(0,0)", "(-970,-1030)", "(1996,2994)"};

    // contains Vectors2d like (x_values1, y_values1) and (x_values2, y_values2)
    final String[] opposite = {"(-1,-1)", "(-1,-1)", "(-1,-2)", "(-2,-2)", "(-3,-5)", "(4,-6)", "(0,0)", "(0,0)", "(-30,30)", "(-1000,-1000)", "(4,6)", "(2000,3000)"};

    Vector2d u;
    Vector2d v;

    @Test
    void equalsTest() {
        for (int i = 0; i < x_values1.length; i++) {
            u = new Vector2d(x_values1[i], y_values1[i]);
            v = new Vector2d(x_values2[i], y_values2[i]);

            if (equals[i]) {
                Assertions.assertTrue(u.equals(v));
            }
            else {
                Assertions.assertFalse(u.equals(v));
            }
        }
    }

    @Test
    void toStringTest() {
        for (int i = 0; i < x_values1.length; i++) {
            u = new Vector2d(x_values1[i], y_values1[i]);
            v = new Vector2d(x_values2[i], y_values2[i]);

            Assertions.assertEquals(toString[2*i], u.toString()); // checking vector u
            Assertions.assertEquals(toString[2*i+1], v.toString()); // checking vector v
        }
    }

    @Test
    void precedesTest() {
        for (int i = 0; i < x_values1.length; i++) {
            u = new Vector2d(x_values1[i], y_values1[i]);
            v = new Vector2d(x_values2[i], y_values2[i]);

            if (precedes[i]) {
                Assertions.assertTrue(u.precedes(v));
            }
            else {
                Assertions.assertFalse(u.precedes(v));
            }
        }
    }

    @Test
    void followsTest() {
        for (int i = 0; i < x_values1.length; i++) {
            u = new Vector2d(x_values1[i], y_values1[i]);
            v = new Vector2d(x_values2[i], y_values2[i]);

            if (follows[i]) {
                Assertions.assertTrue(u.follows(v));
            }
            else {
                Assertions.assertFalse(u.follows(v));
            }
        }
    }

    @Test
    void upperRightTest() {
        for (int i = 0; i < x_values1.length; i++) {
            u = new Vector2d(x_values1[i], y_values1[i]);
            v = new Vector2d(x_values2[i], y_values2[i]);

            Assertions.assertEquals(upperRight[i], u.upperRight(v).toString());
        }
    }

    @Test
    void lowerLeftTest() {
        for (int i = 0; i < x_values1.length; i++) {
            u = new Vector2d(x_values1[i], y_values1[i]);
            v = new Vector2d(x_values2[i], y_values2[i]);

            Assertions.assertEquals(lowerLeft[i], u.lowerLeft(v).toString());
        }
    }

    @Test
    void addTest() {
        for (int i = 0; i < x_values1.length; i++) {
            u = new Vector2d(x_values1[i], y_values1[i]);
            v = new Vector2d(x_values2[i], y_values2[i]);

            Assertions.assertEquals(add[i], u.add(v).toString());
        }
    }

    @Test
    void subtractTest() {
        for (int i = 0; i < x_values1.length; i++) {
            u = new Vector2d(x_values1[i], y_values1[i]);
            v = new Vector2d(x_values2[i], y_values2[i]);

            Assertions.assertEquals(subtract[i], u.subtract(v).toString());
        }
    }

    @Test
    void oppositeTest() {
        for (int i = 0; i < x_values1.length; i++) {
            u = new Vector2d(x_values1[i], y_values1[i]);
            v = new Vector2d(x_values2[i], y_values2[i]);

            Assertions.assertEquals(subtract[i], u.subtract(v).toString());
        }
    }
}
