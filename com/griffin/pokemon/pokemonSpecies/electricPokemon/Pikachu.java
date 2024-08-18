package com.griffin.pokemon.pokemonSpecies.electricPokemon;

import java.util.ArrayList;
import java.util.Arrays;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.types.Electric;

public class Pikachu extends Pokemon implements Electric {
    private static int hp = 39;
    private static int atk = 52;
    private static int def = 43;
    private static int spAtk = 60;
    private static int spDef = 50;
    private static int spe = 65;
    private static ArrayList<String> weaknesses = new ArrayList<>(Arrays.asList(Electric.weaknesses));
    private static ArrayList<String> resistances = new ArrayList<>(Arrays.asList(Electric.weaknesses));
    private static ArrayList<String> immunities = new ArrayList<>(Arrays.asList(Electric.weaknesses));

    
    public Pikachu(String name, int level) {
        super(name, level, weaknesses, resistances, immunities, (hp + level + 10), atk, def, spAtk, spDef, spe);
    }
}
