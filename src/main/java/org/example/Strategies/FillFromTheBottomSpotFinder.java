package org.example.Strategies;

import org.example.Models.ParkingArea.ParkingArea;
import org.example.Models.ParkingSpot.ParkingSpot;
import org.example.Models.Vehicle.Vehicle;

import java.util.List;

public class FillFromTheBottomSpotFinder implements FindFreeSpotStrategy{
    @Override
    public boolean FindFreeSpot(Vehicle vehicle, List<ParkingArea> levels) {
        for (ParkingArea level : levels) {
            for (ParkingSpot spot : level.parkingArea) {
                if (spot.park(vehicle)) {
                    return true;
                }
            }
        }
        return false;
    }
}
