package com.fuzzycar.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Car {
    public final static int WIDTH = 60;
    public final static int LENGTH = 120;
    public final static int Y_VELOCITY = 8;

    private final SimpleDoubleProperty position;
    private double xVelocity;

    public Car(){
        position = new SimpleDoubleProperty(Road.WIDTH / 2.0);
        xVelocity = 0;
    }

    public SimpleDoubleProperty positionProperty() {
        return position;
    }

    public double getPosition() {
        return position.get();
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public void updatePosition(double xVelocityChange){
        xVelocity = xVelocity + xVelocityChange;
        position.set(position.getValue()+xVelocity);
    }


}
