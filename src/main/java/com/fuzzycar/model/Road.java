package com.fuzzycar.model;

import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Road extends Pane {
    public final static int WIDTH = 300;
    public final static int LENGTH = 600;
    public final static int PAD = 10;

    public Road(Car car, Hole hole) {
        Circle holeShape = new Circle(Hole.RADIUS, Color.BLACK);
        holeShape.centerXProperty().bind(hole.xPositionProperty());
        holeShape.centerYProperty().bind(hole.yPositionProperty());

        Rectangle carShape = new Rectangle(Car.WIDTH, Car.LENGTH);
        carShape.fillProperty().setValue(Color.RED);
        carShape.xProperty().bind(Bindings.add(PAD - Car.WIDTH/2, car.positionProperty()));
        carShape.setY(PAD);

        Rectangle roadPad = new Rectangle(Road.WIDTH + 2 * Road.PAD, Road.LENGTH, Color.BLACK);

        Rectangle roadShape = new Rectangle(Road.PAD, 0, Road.WIDTH, Road.LENGTH);
        roadShape.fillProperty().setValue(Color.DIMGRAY);

        this.getChildren().addAll(roadPad, roadShape, holeShape, carShape);
        this.setHeight(Road.LENGTH);
    }
}
