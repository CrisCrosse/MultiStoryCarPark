package org.example.Models.ParkingSpot;

import org.example.VehicleSize;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot() {
        super();
        this.size = VehicleSize.MEDIUM;
    }
}
