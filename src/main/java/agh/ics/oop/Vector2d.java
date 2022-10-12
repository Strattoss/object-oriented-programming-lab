package agh.ics.oop;

import java.util.Objects;
import java.util.Vector;

public class Vector2d {
    public int x;
    public int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "("+Integer.toString(x)+","+Integer.toString(y)+")";
    }

    public boolean precedes(Vector2d other) {
        if (this.x <= other.x && this.y <= other.y) {
            return true;
        }
        else return false;
    }

    public boolean follows(Vector2d other) {
        if (this.x >= other.x && this.y >= other.y) {
            return true;
        }
        else return false;
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x+other.x, this.y+other.y);
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x-other.x, this.y-other.y);
    }

    public Vector2d upperRight(Vector2d other) {
        int a = Math.max(this.x, other.x);
        int b = Math.max(this.y, other.y);
        return new Vector2d(a, b);
    }

    public Vector2d lowerLeft(Vector2d other) {
        int a = Math.min(this.x, other.x);
        int b = Math.min(this.y, other.y);
        return new Vector2d(a, b);
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }

    /*public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return Objects.equals()//
    }*/

}
