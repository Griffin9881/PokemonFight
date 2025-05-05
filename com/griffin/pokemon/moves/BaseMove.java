package com.griffin.pokemon.moves;

import java.util.Random;

import com.griffin.pokemon.Pokemon;

public abstract class BaseMove {
    private String name;
    private final int basePower;
    private final int maxPower;
    private final double accuracy;
    private int powerPoint;
    private Targets target;
    private MoveType moveType;
    private int priority;
    private String type;

    public BaseMove(String name, int basePower, int maxPower, int powerPoint, double accuracy, Targets target, MoveType moveType, int priority, String type) {
        this.name = name;
        this.basePower = basePower;
        this.maxPower = maxPower;
        this.powerPoint = powerPoint;
        this.accuracy = accuracy;
        this.target = target;
        this.moveType = moveType;
        this.priority = priority;
        this.type = type;
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

    public MoveType getMoveType() {
        return this.moveType;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getType() {
        return this.type;
    }
    
    public void activate(Pokemon target) {
    }

    public int execute() {
        Random random = new Random();
        int minPower = basePower - (maxPower - basePower);
        int dmg = random.nextInt(maxPower - minPower) + basePower;
        powerPoint =- 1;
        return dmg;
    }
}
