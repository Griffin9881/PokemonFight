package com.griffin.pokemon.moves;

import java.util.Random;

public abstract class BaseMove {
    private String name;
    private final int basePower;
    private final int maxPower;
    private final double accuracy;
    private int powerPoint;

    public BaseMove(String name, int basePower, int maxPower, int powerPoint, double accuracy) {
        this.name = name;
        this.basePower = basePower;
        this.maxPower = maxPower;
        this.powerPoint = powerPoint;
        this.accuracy = accuracy;
    }

    public String getName() {
        return this.name;
    }

    public int getBasePower() {
        return this.basePower;
    }

    public int getMaxPower() {
        return this.maxPower;
    }

    public int getPowerPoint() {
        return this.powerPoint;
    }

    public double getAccuracy() {
        return this.accuracy;
    }

    public int execute() {
        Random random = new Random();
        int dmg = random.nextInt(maxPower - basePower) + basePower;
        powerPoint =- 1;
        return dmg;
    }
}
