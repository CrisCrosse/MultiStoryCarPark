package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println("creating a thread");
//            TODO look into platform threads and why the runnable isn't being executed'
            var thread = new Thread(new ParkSomeCarsThenMakeThemLeave());
        }
        Thread.sleep(10000);
    }
}