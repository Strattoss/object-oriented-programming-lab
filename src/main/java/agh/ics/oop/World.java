package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartowal");

        Direction[] dirs = strToDir(args);
        run(dirs);

        System.out.println("System zakonczyl dzialanie");
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
