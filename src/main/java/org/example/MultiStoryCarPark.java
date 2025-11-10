package org.example;

import org.example.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MultiStoryCarPark {
    private List<IParkingArea> levels;
    final static private MultiStoryCarPark INSTANCE = new MultiStoryCarPark();

    private MultiStoryCarPark () {
        this.levels = new ArrayList<>(5);
    }

    public static MultiStoryCarPark getInstance() {
        return INSTANCE;
    }

    public boolean enter(Vehicle vehicle) {
        return false;
    }

    public boolean leave(Vehicle vehicle) {
        return false;
    }
}
