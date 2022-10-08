package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartowal");

        System.out.println("#run1");
        run1();

        System.out.println("#run2");
        run2(args);

        System.out.println("#run3");
        run3(args);

        System.out.println("#run4");
        Direction[] dirs = strToDir(args);
        run4(dirs);

        //run4(dirs);

        System.out.println("System zakonczyl dzialanie");
    }

    static Direction[] strToDir(String[] strs) {
        int valid_chars = 0;
        for (int i=0; i<strs.length; i++) {
            if (strs[i].equals("f") ||
                    strs[i].equals("b") ||
                    strs[i].equals("l") ||
                    strs[i].equals("r")) {
                valid_chars+=1;
            }
        }

        Direction[] dirs = new Direction[valid_chars];
        int j = 0;

        for (int i=0; i<strs.length; i++) {
            switch (strs[i]) {
                case "f":
                    dirs[j] = Direction.FORWARD;
                    j += 1;
                    break;
                case "b":
                    dirs[j] = Direction.BACKWARD;
                    j += 1;
                    break;
                case "l":
                    dirs[j] = Direction.LEFT;
                    j += 1;
                    break;
                case "r":
                    dirs[j] = Direction.RIGHT;
                    j += 1;
                    break;
            }
        }

        return dirs;
    }

    static void run1() {
        System.out.println("Zwierzak idzie do przodu");
    }

    static void run2(String[] args) {
        System.out.println("Zwierzak idzie do przodu");

        System.out.print(args[0]);
        for (int i = 1; i < args.length; i++) {
            System.out.print(", "+args[i]);
        }
        System.out.println();
    }

    static void run3(String[] dirs) {
        for (String dir:dirs) {
            switch (dir) {
                case "f" -> System.out.println("Zwierzak idzie do przodu");
                case "b" -> System.out.println("Zwierzak idzie do tylu");
                case "l" -> System.out.println("Zwierzak idzie w lewo");
                case "r" -> System.out.println("Zwierzak idzie w prawo");
            }
        }
    }

    static void run4(Direction[] dirs) {
        for (int i = 0; i < dirs.length; i++) {
            switch (dirs[i]) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
            }
        }
    }
}
