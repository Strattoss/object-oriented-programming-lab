package agh.ics.oop;

public class OptionParser {

    public static MoveDirection[] parse(String[] md) {
        int validInstr = 0;
        for (String s : md) {
            switch (s) {
                case "f", "forward", "b", "backward", "l", "left", "r", "right" -> validInstr += 1;
            }
        }

        MoveDirection[] res = new MoveDirection[validInstr];

        int j = 0;
        for (String s : md) {
            switch (s) {
                case "f", "forward" -> {
                    res[j] = MoveDirection.FORWARD;
                    j++;
                }
                case "b", "backward" -> {
                    res[j] = MoveDirection.BACKWARD;
                    j++;
                }
                case "l", "left" -> {
                    res[j] = MoveDirection.LEFT;
                    j++;
                }
                case "r", "right" -> {
                    res[j] = MoveDirection.RIGHT;
                    j++;
                }
            }
        }
        return res;
    }
}
