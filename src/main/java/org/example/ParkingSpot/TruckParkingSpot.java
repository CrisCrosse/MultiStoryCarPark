package org.example.ParkingSpot;

import org.example.VehicleSize;

public class TruckParkingSpot extends ParkingSpot {
    public TruckParkingSpot() {
        super();
        this.size = VehicleSize.LARGE;
    }
}
