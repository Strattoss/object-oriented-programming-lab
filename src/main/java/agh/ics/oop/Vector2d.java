package agh.ics.oop;

public class Vector2d {
	final public int x;
	final public int y;

	public Vector2d(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public boolean precedes(Vector2d other) {
		return this.x <= other.x && this.y <= other.y;
	}

	public boolean follows(Vector2d other) {
		return this.x >= other.x && this.y >= other.y;
	}

	public Vector2d add(Vector2d other) {
		return new Vector2d(this.x + other.x, this.y + other.y);
	}

	public Vector2d subtract(Vector2d other) {
		return new Vector2d(this.x - other.x, this.y - other.y);
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

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vector2d other))
			return false;
		return this.x == other.x && this.y == other.y;
	}

	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + this.x;
		hash = 31 * hash + this.y;
		return hash;
	}

}
