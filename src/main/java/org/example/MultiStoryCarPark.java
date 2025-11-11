package org.example;

import org.example.ParkingArea.EvenlyDistributedParkingAreaCreator;
import org.example.ParkingArea.IParkingAreaCreator;
import org.example.ParkingArea.ParkingArea;
import org.example.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MultiStoryCarPark {
    private List<ParkingArea> levels;
    final private int NUMBER_OF_LEVELS = 5;
    final private int SPACES_PER_LEVEL = 30;
    final static private MultiStoryCarPark INSTANCE = new MultiStoryCarPark(new EvenlyDistributedParkingAreaCreator());
    private IParkingAreaCreator parkingSpotMakeupStrategy;

    private MultiStoryCarPark (IParkingAreaCreator parkingSpotMakeupStrategy) {
        this.parkingSpotMakeupStrategy = parkingSpotMakeupStrategy;
        this.levels = new ArrayList<>(NUMBER_OF_LEVELS);
        for (int i = 0; i < NUMBER_OF_LEVELS; i++) {
            this.levels.add(this.parkingSpotMakeupStrategy.buildParkingArea(SPACES_PER_LEVEL));
        }

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
