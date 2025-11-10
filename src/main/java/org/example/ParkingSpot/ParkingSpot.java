package org.example.ParkingSpot;

import org.example.Vehicle.Vehicle;
import org.example.VehicleSize;

public abstract class ParkingSpot {
    protected VehicleSize size;
    private Vehicle vehicle;

    public ParkingSpot() {}

    public boolean park(Vehicle vehicle) {
        if (vehicle.getSize() != this.size || this.vehicle != null) {
            return false;
        }
        this.vehicle = vehicle;
        return true;
    }

    public void release() {
        this.vehicle = null;
    }
}
