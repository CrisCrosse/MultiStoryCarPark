package org.example;

import org.example.ParkingArea.EvenlyDistributedParkingAreaCreator;
import org.example.ParkingArea.IParkingAreaCreator;
import org.example.ParkingArea.ParkingArea;
import org.example.ParkingSpot.ParkingSpot;
import org.example.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// TODO: add payment interface

public class MultiStoryCarPark {
//    final means that this instance variable can only be assigned a value once in the constructor
    final private HashSet<Vehicle> vehiclesCurrentlyInside;
    final private List<ParkingArea> levels;
    final private int NUMBER_OF_LEVELS = 5;
    final private int SPACES_PER_LEVEL = 30;
    final static private MultiStoryCarPark INSTANCE = new MultiStoryCarPark(new EvenlyDistributedParkingAreaCreator());

    private MultiStoryCarPark (IParkingAreaCreator parkingSpotMakeupStrategy) {
        this.levels = new ArrayList<>(NUMBER_OF_LEVELS);
        for (int i = 0; i < NUMBER_OF_LEVELS; i++) {
            this.levels.add(parkingSpotMakeupStrategy.buildParkingArea(SPACES_PER_LEVEL));
        }
        vehiclesCurrentlyInside = new HashSet<>(NUMBER_OF_LEVELS * SPACES_PER_LEVEL);
    }

    public static MultiStoryCarPark getInstance() {
        return INSTANCE;
    }

    /**
     * @param vehicle vehicle to park
     * @return returns false if the vehicle is already inside the car park, the car park is full
     * or there are no suitable space types. Otherwise, true.
     */
    public boolean enter(Vehicle vehicle) {
        if (vehiclesCurrentlyInside.size() == NUMBER_OF_LEVELS * SPACES_PER_LEVEL) {
            return false;
        }
        if (vehiclesCurrentlyInside.contains(vehicle)) {
            return false;
        }

        for (ParkingArea level : levels) {
            for (ParkingSpot spot : level.parkingArea) {
                if (spot.park(vehicle)) {
                    vehiclesCurrentlyInside.add(vehicle);
                    return true;
                }
            }
        }
        //        should never reach this due to the set check
        return false;
    }

    /**
     * @param vehicle vehicle to make leave the car park
     * @return returns false if the vehicle was not inside the car park. Otherwise, true.
     */
    public boolean leave(Vehicle vehicle) {
        if (!vehiclesCurrentlyInside.contains(vehicle)) {
            return false;
        }
        for (ParkingArea level : levels) {
            for (ParkingSpot spot : level.parkingArea) {
                if (spot.release(vehicle)) {
                    vehiclesCurrentlyInside.remove(vehicle);
                    return true;
                }
            }
        }
//        should never reach this due to the set check
        return false;
    }
}
