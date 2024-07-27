package com.tripservice.trip;

public class Trip {
    private String toDestination;
    private int distance;
    private double fuelConsumption;
    private double fuelPrice;
    private double fuelEfficiency;
    private double cost;
    private double fuelAmount;

    public Trip( String toDestination,int distance, double fuelConsumption, double fuelPrice, double fuelEfficiency) {
            this.toDestination = toDestination;
            this.distance = distance;
            this.fuelConsumption = fuelConsumption;
            this.fuelPrice = fuelPrice;
            this.fuelEfficiency = fuelEfficiency;
            this.calculateCost();
    }

    private void calculateCost() {
        this.fuelAmount = this.distance / this.fuelEfficiency;
        this.cost = this.fuelAmount * this.fuelPrice;
        System.out.println("Total cost: " + this.cost);
    }
}
