package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegratingTest {
    // this test contains every risky situation: animals colliding, trying to go over allowed borders of the map,
    // moving in all directions and so on
    String[] testArgs = {"f",  "b",  "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f",
            "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
    MoveDirection[] testMD = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT,
            MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT,
            MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
            MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
            MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD,
            MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
            MoveDirection.FORWARD, MoveDirection.FORWARD};

    @Test
    void test() {
        // test parser
        Assertions.assertArrayEquals(testMD, new OptionParser().parse(testArgs));

        // create map and engine
        IWorldMap map = new RectangularMap(6, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(testMD, map, positions);
        engine.run();

        // checking final position og Animals
        Assertions.assertEquals(new Vector2d(0, 0), engine.getAnimal(0).getPosition());
        Assertions.assertEquals(new Vector2d(6, 5), engine.getAnimal(1).getPosition());
    }
}
