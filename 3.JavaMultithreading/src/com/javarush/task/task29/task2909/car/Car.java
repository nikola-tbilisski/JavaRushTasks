package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers){
        switch (type){
            case TRUCK:
                return new Truck(numberOfPassengers);

            case SEDAN:
                return new Sedan(numberOfPassengers);

            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);

            default: return null;

        }
    }

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && this.fuel > 0;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0) {
            throw new Exception();
        }
        this.fuel += numberOfLiters;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        if(date.after(summerStart) && date.before(summerEnd)) return true;
        else return false;
    }

    public double getWinterConsumption(int length) {
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {
        return isSummer(date, summerStart, summerEnd) ? getSummerConsumption(length) : getWinterConsumption(length);
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred()) return numberOfPassengers;
        return 0;
//        if (!isDriverAvailable())
//            return 0;
//        if (fuel <= 0)
//            return 0;
//
        //return canPassengersBeTransferred() ? numberOfPassengers : 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
//        if (numberOfPassengers > 0) {
//            fastenPassengersBelts();
//            fastenDriverBelt();
//        } else {
//            fastenDriverBelt();
//        }
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

     public abstract int getMaxSpeed();
}