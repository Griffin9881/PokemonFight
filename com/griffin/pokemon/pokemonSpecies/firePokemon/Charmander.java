package com.griffin.pokemon.pokemonSpecies.firePokemon;

import java.util.ArrayList;
import java.util.Arrays;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.types.Fire;

public class Charmander extends Pokemon implements Fire {
    private static int hp = 35;
    private static int atk = 55;
    private static int def = 40;
    private static int spAtk = 50;
    private static int spDef = 50;
    private static int spe = 90;
    private static ArrayList<String> weaknesses = new ArrayList<>(Arrays.asList(Fire.weaknesses));
    private static ArrayList<String> resistances = new ArrayList<>(Arrays.asList(Fire.weaknesses));
    private static ArrayList<String> immunities = new ArrayList<>(Arrays.asList(Fire.weaknesses));
    
    public Charmander(String name, int level) {
        super(name, level, weaknesses, resistances, immunities, (hp + level + 10), atk, def, spAtk, spDef, spe);    }
}
