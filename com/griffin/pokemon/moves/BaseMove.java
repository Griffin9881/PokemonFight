package com.griffin.pokemon.moves;

import java.util.Random;

public abstract class BaseMove {
    private String name;
    private final int basePower;
    private final int maxPower;
    private final double accuracy;
    private int powerPoint;
    private Targets target;
    private MoveType moveType;

    public BaseMove(String name, int basePower, int maxPower, int powerPoint, double accuracy, Targets target, MoveType moveType) {
        this.name = name;
        this.basePower = basePower;
        this.maxPower = maxPower;
        this.powerPoint = powerPoint;
        this.accuracy = accuracy;
        this.target = target;
        this.moveType = moveType;
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

    public Targets getTarget() {
        return this.target;
    }

    public int execute() {
        Random random = new Random();
        int minPower = basePower - (maxPower - basePower);
        int dmg = random.nextInt(maxPower - minPower) + basePower;
        powerPoint =- 1;
        return dmg;
    }
}
