package org.example;

import org.example.Vehicle.Car;
import org.example.Vehicle.Motorcycle;
import org.example.Vehicle.Truck;

public class ParkSomeCarsThenMakeThemLeave implements Runnable {
    @Override
    public void run() {
        System.out.printf("In Thread %s and about to park three vehicles%n", Thread.currentThread().threadId());
        var carParkInstance = MultiStoryCarPark.getInstance();

        var car = new Car();
        var truck = new Truck();
        var motorcycle = new Motorcycle();

        carParkInstance.enter(car);
        carParkInstance.enter(truck);
        carParkInstance.enter(motorcycle);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
            return;
        }
        System.out.printf("In Thread %s and about to make three vehicles leave%n", Thread.currentThread().threadId());


        carParkInstance.leave(car);
        carParkInstance.leave(truck);
        carParkInstance.leave(motorcycle);
    }
}
