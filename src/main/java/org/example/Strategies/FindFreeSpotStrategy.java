package org.example.Strategies;

import org.example.Models.ParkingArea.ParkingArea;
import org.example.Models.Vehicle.Vehicle;

import java.util.List;

public interface FindFreeSpotStrategy {
    boolean FindFreeSpot(Vehicle vehicle, List<ParkingArea> levels);
}
