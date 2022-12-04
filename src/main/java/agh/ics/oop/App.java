package agh.ics.oop;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {
    AbstractWorldMap map;
    SimulationEngine engine;
    GridPane grid;
    Thread engineThread;
    Button startButton;
    TextField textFieldMoveDirections;
    Scene myScene;
    @Override
    public void init() {
        try {
            AbstractWorldMap map = new GrassField(10);
            this.map = map;

            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            this.engine = new SimulationEngine(map, positions);
            this.engine.setApplication(this);
            this.engine.setMoveDelay(300);

            //engineThread = new Thread(engine);

            this.grid = new GridPane();
            grid.setGridLinesVisible(true);

            buildGrid();

            textFieldMoveDirections = new TextField();
            startButton = new Button("Start");
            startButton.setOnAction(event -> {
                engine.setMd((new OptionParser()).parse(textFieldMoveDirections.getText().split(" ")));
                engineThread = new Thread(engine);
                engineThread.start();
            });
            VBox nav = new VBox(startButton, textFieldMoveDirections);

            HBox root = new HBox();
            root.getChildren().addAll(grid, nav);

            myScene = new Scene(root, 400, 400);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Map: Animals and Grass");

        primaryStage.setScene(myScene);
        primaryStage.show();
        System.out.println(map);

        //engineThread.start();
    }

    public void updateGrid() {
        Platform.runLater(() -> {
            buildGrid();
            System.out.println(map);
        });
    }

    private void buildGrid() {
        grid.getChildren().clear();
        grid.getRowConstraints().clear();
        grid.getColumnConstraints().clear();

        int leftX = map.getBottomLeftCorner().x;
        int rightX = map.getUpperRightCorner().x;
        int bottomY = map.getBottomLeftCorner().y;
        int upperY = map.getUpperRightCorner().y;

        // Building map axes
        Label label;
        grid.add(new Label("y\\x"), 0, 0);
        for (int i = leftX; i <= rightX; i++) { grid.getColumnConstraints().add(new ColumnConstraints(20)); }
        for (int i = bottomY; i <= upperY; i++) { grid.getRowConstraints().add(new RowConstraints(20)); }

        for (int i = 0; i <= rightX-leftX; i++) {
            label = new Label(Integer.toString(i+leftX));
            grid.add(label, i+1, 0);
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int i = 0; i <= upperY-bottomY; i++) {
            label = new Label(Integer.toString(i + bottomY));
            grid.add(label, 0, upperY - i+1);
            GridPane.setHalignment(label, HPos.CENTER);
        }

        // Placing objects from the map on the grid
        VBox vBox;
        IMapElement mapElement;
        for (int i = 0; i <= rightX-leftX; i++) {
            for (int j = 0; j <= upperY-bottomY; j++) {
                mapElement = (IMapElement) map.objectAt(new Vector2d(i+leftX, j+bottomY));
                if (mapElement != null) {
                    vBox = mapElement.getGui().getVBox();

                    grid.add(vBox, i + 1, upperY -j + 1);
                    GridPane.setHalignment(vBox, HPos.CENTER);
                }
            }
        }

        grid.setGridLinesVisible(true);
    }
}
