package com.fuzzycar;

import com.fuzzycar.driver.CarDriver;
import com.fuzzycar.model.Car;
import com.fuzzycar.model.Hole;
import com.fuzzycar.model.Road;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Hole hole = new Hole(160);
        Car car = new Car();
        Road road = new Road(car, hole);

        stage.setScene(new Scene(road));
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();

        stage.setOnCloseRequest(e -> {
            System.exit(0);
        });

        new Thread(() -> {
            CarDriver driver = new CarDriver(car, hole);
            while (true){
                try {
                    Thread.sleep(15);
                    double velocityChange = driver.getVelocityChange();
                    Platform.runLater(()->{
                        hole.updatePosition();
                        car.updatePosition(velocityChange);
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
