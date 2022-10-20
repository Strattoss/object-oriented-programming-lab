package agh.ics.oop;

public class OptionParser {
    public MoveDirection parse(String[] md) {
        int validInstructions = 0;
        for (int i=0; i<md.length; i++) {
            switch (md[i]) {
                case "f", "forward", "b", "backward", "l", "left", "r", "right" -> validInstructions += 1;
            }
        }
    }
}
