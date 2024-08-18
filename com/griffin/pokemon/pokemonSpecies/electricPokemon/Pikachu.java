package com.griffin.pokemon.pokemonSpecies.electricPokemon;

import java.util.ArrayList;
import java.util.Arrays;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.types.Electric;

public class Pikachu extends Pokemon implements Electric {
    private static ArrayList<String> weaknesses = new ArrayList<>(Arrays.asList(Electric.weaknesses));
    private static ArrayList<String> resistances = new ArrayList<>(Arrays.asList(Electric.weaknesses));
    private static ArrayList<String> immunities = new ArrayList<>(Arrays.asList(Electric.weaknesses));

    
    public Pikachu(String name, int level) {
        super(name, level, weaknesses, resistances, immunities);
    }
}
