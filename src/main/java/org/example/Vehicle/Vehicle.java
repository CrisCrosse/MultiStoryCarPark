package org.example.Vehicle;

import org.example.VehicleSize;

public abstract class Vehicle {
    private boolean parked;
    private int parkingSpotId;
    protected VehicleSize size;

    public Vehicle() {
        this.parked = false;
        this.parkingSpotId = -1;
    }

    public VehicleSize getSize() {
        return this.size;
    }

    public void park(int parkingSpotId) {
        this.parked = true;
        this.parkingSpotId = parkingSpotId;
    }
    public int leave() {
        this.parked = false;
        var freedParkingSpot = this.parkingSpotId;
        this.parkingSpotId = -1;
        return freedParkingSpot;
    }

}
