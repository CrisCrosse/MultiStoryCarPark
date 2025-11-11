package org.example.Models.ParkingArea;

import org.example.Models.ParkingSpot.ParkingSpot;

import java.util.List;

public class ParkingArea {
    public List<ParkingSpot> parkingArea;

    public ParkingArea(List<ParkingSpot> parkingArea) {
        this.parkingArea = parkingArea;
    }
}
