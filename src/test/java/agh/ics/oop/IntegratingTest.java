package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegratingTest {
    String[][] args = {{"f", "lk"},
            {"l", "ggg", "backward", "jj"},
            {"www", "ww", "right", "ww", "f", "po", "left", "forward"},
            {"f", "f", "f", "f", "f", "r", "b", "b", "b", "b", "b"}};
    MoveDirection[][] movDir = {{MoveDirection.FORWARD},
            {MoveDirection.LEFT, MoveDirection.BACKWARD},
            {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD},
            {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD}};
    String[] results = {"Animal position: (2,3), orientation: north",
            "Animal position: (3,2), orientation: west",
            "Animal position: (3,3), orientation: north",
            "Animal position: (0,4), orientation: east"};

    @Test
    void test() {
        for (int i = 0; i < args.length; i++) {
            Assertions.assertArrayEquals(movDir[i], OptionParser.parse(args[i]));
            Animal dog = new Animal();
            for (MoveDirection md : movDir[i]) {
                dog.move(md);
            }
            Assertions.assertEquals(dog.toString(), results[i]);
        }
    }

}
