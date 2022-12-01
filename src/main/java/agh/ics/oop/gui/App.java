package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    AbstractWorldMap map;
    @Override
    public void init() {
        try {
            String[] args = getParameters().getRaw().toArray(new String[0]);
            MoveDirection[] directions = new OptionParser().parse(args);

            AbstractWorldMap map = new GrassField(10);
            this.map = map;

            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            System.out.println(map);


            /*directions = new OptionParser().parse(args);
            map = new GrassField(10);
            Animal cow = new Animal(map, new Vector2d(2, 2));

            for (MoveDirection direction : directions) {
                cow.move(direction);
                System.out.println(map);
            }*/
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }


    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Map: Animals and Grass");

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);



        int leftX = map.getBottomLeftCorner().x;
        int rightX = map.getUpperRightCorner().x;
        int bottomY = map.getBottomLeftCorner().y;
        int upperY = map.getUpperRightCorner().y;

        /* Building map axes */
        Label label;
        grid.add(new Label("x/y"), 0, 0);

        //temporary
        VBox vBox;

        for (int i = leftX; i <= rightX; i++) {
            label = new Label(Integer.toString(i));

            grid.add(label, i+1, 0);
            GridPane.setHalignment(label, HPos.CENTER);
            grid.getColumnConstraints().add(new ColumnConstraints(20));
        }
        grid.getColumnConstraints().add(new ColumnConstraints(20));


        for (int i = bottomY; i <= upperY; i++) {
            label = new Label(Integer.toString(i));
            grid.add(label, 0, upperY - i + 1, 1, 1);
            GridPane.setHalignment(label, HPos.CENTER);
            grid.getRowConstraints().add(new RowConstraints(20));
        }
        grid.getRowConstraints().add(new RowConstraints(20));

        /* Placing objects on the map */
        Object o;
        for (int i = leftX; i <= rightX; i++) {
            for (int j = bottomY; j <= upperY; j++) {
                o = map.objectAt(new Vector2d(i, j));
                if (o != null) {
                    label = new Label(o.toString());
                    grid.add(label, i + 1, upperY - j + 1, 1, 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        Scene scene = new Scene(grid, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
