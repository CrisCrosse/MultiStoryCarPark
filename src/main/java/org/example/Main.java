package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            System.out.println("creating a thread");
            var thread = new Thread(new ParkSomeCarsThenMakeThemLeave());
            thread.start();
        }
        Thread.sleep(10000);
    }
}