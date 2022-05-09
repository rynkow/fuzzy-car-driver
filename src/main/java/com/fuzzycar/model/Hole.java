package com.fuzzycar.model;

import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

public class Hole {
    public final static int RADIUS = 20;

    private final SimpleIntegerProperty xPosition;
    private final SimpleIntegerProperty yPosition;

    public Hole(int xPosition) {
        this.xPosition = new SimpleIntegerProperty(xPosition);
        this.yPosition = new SimpleIntegerProperty(Road.LENGTH - RADIUS);
    }

    public SimpleIntegerProperty xPositionProperty() {
        return xPosition;
    }

    public SimpleIntegerProperty yPositionProperty() {
        return yPosition;
    }

    public int getxPosition() {
        return xPosition.get();
    }

    public void updatePosition(){
        if (yPosition.getValue() - Car.Y_VELOCITY < RADIUS){
            yPosition.set(Road.LENGTH - RADIUS);
            xPosition.set( Road.PAD + RADIUS + new Random().nextInt(Road.WIDTH - 2*RADIUS));
        } else {
            yPosition.set(yPosition.getValue() - Car.Y_VELOCITY);
        }
    }
}
