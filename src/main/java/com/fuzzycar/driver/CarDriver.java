package com.fuzzycar.driver;

import com.fuzzycar.model.Car;
import com.fuzzycar.model.Hole;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class CarDriver {
    private final static String fclPath = "src/main/resources/fuzzyDriver.fcl";

    private FIS fis;
    private final Car car;
    private final Hole hole;

    public CarDriver(Car car, Hole hole) {
        this.car = car;
        this.hole = hole;

        this.fis = FIS.load(fclPath, false);
        JFuzzyChart.get().chart(fis);
    }

    public double getVelocityChange(){
        fis.setVariable("hole_position", hole.getxPosition());
        fis.setVariable("x_car_velocity", car.getxVelocity());
        fis.setVariable("car_position", car.getPosition());
        fis.setVariable("hole_relative_position", hole.getxPosition() - car.getPosition());

        fis.evaluate();

        Variable v = fis.getVariable("velocity_change");

        return v.getValue();
    }


}
