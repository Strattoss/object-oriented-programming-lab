package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import agh.ics.oop.IPositionChangeObserver;
import agh.ics.oop.Vector2d;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GuiElementBox implements IPositionChangeObserver {
    private final IMapElement mapElement;
    private VBox vBox;

    public GuiElementBox(IMapElement mapElement) {
        this.mapElement = mapElement;
        changeImg();
    }

    public VBox getVBox() {
        return vBox;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        changeImg();
    }

    private void changeImg() {
        Image img = new Image(mapElement.getImgURL());
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(20);
        imgView.setFitHeight(20);
        Label label = new Label(mapElement.toString());
        vBox = new VBox(imgView);
        vBox.setAlignment(Pos.CENTER);

        // inform GUI to update view

    }
}
