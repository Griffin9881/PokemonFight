package com.griffin.pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.griffin.pokemon.moves.BaseMove;

public abstract class Pokemon {
    private String name;
    private int level;
    private ArrayList<String> weaknesses;
    private ArrayList<String> resistances;
    private ArrayList<String> immunities;
    private BaseMove move1;
    private BaseMove move2;
    private BaseMove move3;
    private BaseMove move4;
    
    public Pokemon(String name, int level, ArrayList<String> weaknesses, ArrayList<String> resistances, ArrayList<String> immunities) {
        this.name = name;
        this.level = level;
        this.weaknesses = weaknesses;
        this.resistances = resistances;
        this.immunities = immunities;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<String> getWeaknesses() {
        return weaknesses;
    }

    public ArrayList<String> getResistances() {
        return resistances;
    }

    public ArrayList<String> getImmunities() {
        return immunities;
    }

    public void gainImmunity(String immunity) {
        immunities.add(immunity);
    }

    public void learnMove(BaseMove move) {
        if (move1 == null) {
            move1 = move;
        } else if(move2 == null) {
            move2 = move;
        } else if(move3 == null) {
            move3 = move;
        } else if(move4 == null) {
            move4 = move;
        }
    }

}