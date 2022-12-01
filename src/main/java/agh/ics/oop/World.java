package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {

    public static void main(String[] args) {
        /*try {
            MoveDirection[] directions = new OptionParser().parse(args);

            AbstractWorldMap map = new RectangularMap(10, 10);

            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 3)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            System.out.println(map.getBottomLeftCorner());
            System.out.println(map.getUpperRightCorner());

            System.out.println(map);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }*/

        Application.launch(App.class, args);
    }
}
