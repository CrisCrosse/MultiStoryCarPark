package org.example.Models.ParkingArea;

import org.example.Models.ParkingSpot.CarParkingSpot;
import org.example.Models.ParkingSpot.MotorcycleParkingSpot;
import org.example.Models.ParkingSpot.ParkingSpot;
import org.example.Models.ParkingSpot.TruckParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class EvenlyDistributedParkingAreaCreator implements IParkingAreaCreator {

// TODO:could make this actually use an area to distribute the space between parking areas
    @Override
    public ParkingArea buildParkingArea(int totalSpaces) {
        List<ParkingSpot> parkingSpots = new ArrayList<>(totalSpaces);

        for (int i = 0; i < totalSpaces; i++) {

            int parkingType = i % 3;
            switch (parkingType) {
                case 0:
                    parkingSpots.add(new MotorcycleParkingSpot());
                    break;
                case 1:
                    parkingSpots.add(new CarParkingSpot());
                    break;
                case 2:
                    parkingSpots.add(new TruckParkingSpot());
                    break;
            }
        }
        return new ParkingArea(parkingSpots);
    }
}
