package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionParserTest {
    @Test
    public void parseTest() {
        String[] testArgs1 = {"f",  "b",  "right", "left", "forward", "f", "r", "r"};
        MoveDirection[] testMD1 = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT};

        Assertions.assertArrayEquals(new OptionParser().parse(testArgs1), testMD1);

        String[] testArgs2 = {"f",  "ty-ty"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new OptionParser().parse(testArgs2); });
    }
}
