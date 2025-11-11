package org.example;

import org.example.Models.ParkingArea.EvenlyDistributedParkingAreaCreator;
import org.example.Models.ParkingArea.IParkingAreaCreator;
import org.example.Models.ParkingArea.ParkingArea;
import org.example.Models.ParkingSpot.ParkingSpot;
import org.example.Models.Vehicle.Vehicle;
import org.example.Strategies.FillFromTheBottomSpotFinder;
import org.example.Strategies.FindFreeSpotStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// TODO: add payment interface

public class MultiStoryCarPark {
//    final means that this instance variable can only be assigned a value once in the constructor
    final private HashSet<Vehicle> parkedVehicles;
    final private List<ParkingArea> levels;
    final private int NUMBER_OF_LEVELS = 5;
    final private int SPACES_PER_LEVEL = 30;
    final private FindFreeSpotStrategy findFreeSpotStrategy;
    final static private MultiStoryCarPark INSTANCE = new MultiStoryCarPark(new EvenlyDistributedParkingAreaCreator(),
            new FillFromTheBottomSpotFinder());


    private MultiStoryCarPark (IParkingAreaCreator parkingSpotMakeupStrategy,
                               FindFreeSpotStrategy findFreeSpotStrategy) {
        this.levels = new ArrayList<>(NUMBER_OF_LEVELS);
        for (int i = 0; i < NUMBER_OF_LEVELS; i++) {
            this.levels.add(parkingSpotMakeupStrategy.buildParkingArea(SPACES_PER_LEVEL));
        }
        this.parkedVehicles = new HashSet<>(NUMBER_OF_LEVELS * SPACES_PER_LEVEL);
        this.findFreeSpotStrategy = findFreeSpotStrategy;
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
        if (parkedVehicles.size() == NUMBER_OF_LEVELS * SPACES_PER_LEVEL) {
            return false;
        }
        if (parkedVehicles.contains(vehicle)) {
            return false;
        }

        if (findFreeSpotStrategy.FindFreeSpot(vehicle, levels)) {
            parkedVehicles.add(vehicle);
        }
        return false;
    }

    /**
     * @param vehicle vehicle to make leave the car park
     * @return returns false if the vehicle was not inside the car park. Otherwise, true.
     */
    public boolean leave(Vehicle vehicle) {
        if (!parkedVehicles.contains(vehicle)) {
            return false;
        }
        for (ParkingArea level : levels) {
            for (ParkingSpot spot : level.parkingArea) {
                if (spot.release(vehicle)) {
                    parkedVehicles.remove(vehicle);
                    return true;
                }
            }
        }
//        should never reach this due to the set check
        return false;
    }
}
