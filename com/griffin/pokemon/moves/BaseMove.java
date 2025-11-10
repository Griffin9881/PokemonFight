package com.griffin.pokemon.moves;

import java.util.Random;

import com.griffin.pokemon.Pokemon;

public abstract class BaseMove {
    private String name;
    private final int basePower;
    private final double accuracy;
    private int powerPoint;
    private Targets target;
    private MoveType moveType;
    private int priority;
    private String type;

    public BaseMove(String name, int basePower, int powerPoint, double accuracy, Targets target, MoveType moveType, int priority, String type) {
        this.name = name;
        this.basePower = basePower;
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
        int dmg = basePower;
        powerPoint =- 1;
        return dmg;
    }
}
