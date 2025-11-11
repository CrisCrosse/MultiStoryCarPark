package org.example.Strategies;

import org.example.Models.ParkingArea.ParkingArea;
import org.example.Models.ParkingSpot.ParkingSpot;
import org.example.Models.Vehicle.Vehicle;

import java.util.List;

public class FillFromTheTopSpotFinder implements FindFreeSpotStrategy{
    @Override
    public boolean FindFreeSpot(Vehicle vehicle, List<ParkingArea> levels) {
        for (int i = levels.size() - 1; i > 0; i--) {
            var level = levels.get(i);
            for (ParkingSpot spot : level.parkingArea) {
                if (spot.park(vehicle)) {
                    return true;
                }
            }
        }
        return false;
    }
}
