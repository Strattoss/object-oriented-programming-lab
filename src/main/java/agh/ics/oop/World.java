package agh.ics.oop;

public class World {
    public static void main(String[] args) {

        // manual checking if Vector2d.toString and Vector2d.add work properly
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        // manual checking if MapDirection works properly
        MapDirection a = MapDirection.NORTH;
        System.out.println(a.toString());
        System.out.println(a.next());
        System.out.println(a.previous());
        System.out.println(MapDirection.SOUTH);
        System.out.println(a.toUnitVector());
        System.out.println(a.equals(MapDirection.NORTH));
        System.out.println(a.equals(MapDirection.SOUTH));
    }

    static Direction[] strToDir(String[] strs) {
        int valid_chars = 0;
        for (String s : strs) {
            if (s.equals("f") ||
                    s.equals("b") ||
                    s.equals("l") ||
                    s.equals("r")) {
                valid_chars += 1;
            }
        }

        Direction[] dirs = new Direction[valid_chars];
        int j = 0;

        for (String str : strs) {
            switch (str) {
                case "f" -> {
                    dirs[j] = Direction.FORWARD;
                    j += 1;
                }
                case "b" -> {
                    dirs[j] = Direction.BACKWARD;
                    j += 1;
                }
                case "l" -> {
                    dirs[j] = Direction.LEFT;
                    j += 1;
                }
                case "r" -> {
                    dirs[j] = Direction.RIGHT;
                    j += 1;
                }
            }
        }

        return dirs;
    }

    static void run(Direction[] dirs) {
        for (Direction dir : dirs) {
            switch (dir) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
            }
        }
    }
}
