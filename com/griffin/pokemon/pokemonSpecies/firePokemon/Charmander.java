package com.griffin.pokemon.pokemonSpecies.firePokemon;

import java.util.ArrayList;
import java.util.Arrays;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.types.Fire;

public class Charmander extends Pokemon implements Fire {
    private static ArrayList<String> weaknesses = new ArrayList<>(Arrays.asList(Fire.weaknesses));
    private static ArrayList<String> resistances = new ArrayList<>(Arrays.asList(Fire.weaknesses));
    private static ArrayList<String> immunities = new ArrayList<>(Arrays.asList(Fire.weaknesses));
    
    public Charmander(String name, int level) {
        super(name, level, weaknesses, resistances, immunities);
    }
}
