package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GuiElementBox {
    IMapElement mapElement;
    Image img;
    ImageView imgView;
    Label label;
    VBox vBox;

    public GuiElementBox(IMapElement mapElement) {
        this.mapElement = mapElement;
        this.img = new Image(mapElement.getImgURL());
        this.imgView = new ImageView(img);
        imgView.setFitWidth(20);
        imgView.setFitHeight(20);
        label = new Label(mapElement.toString());
        vBox = new VBox(imgView, label);
        vBox.setAlignment(Pos.CENTER);
    }
}
