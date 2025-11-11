package org.example.Models.ParkingSpot;

import org.example.VehicleSize;

public class TruckParkingSpot extends ParkingSpot {
    public TruckParkingSpot() {
        super();
        this.size = VehicleSize.LARGE;
    }
}
