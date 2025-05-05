package com.griffin.pokemon.pokemonSpecies.grassPokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.moves.AllMoves;
import com.griffin.pokemon.types.Grass;

public class Bulbasaur extends Pokemon implements Grass {
    private static String type = "Grass";
    private static int hp = 45;
    private static int atk = 49;
    private static int def = 49;
    private static int spAtk = 65;
    private static int spDef = 65;
    private static int spe = 45;
    private static ArrayList<String> weaknesses = new ArrayList<>(Arrays.asList(Grass.weaknesses));
    private static ArrayList<String> resistances = new ArrayList<>(Arrays.asList(Grass.weaknesses));
    private static ArrayList<String> immunities = new ArrayList<>(Arrays.asList(Grass.weaknesses));
    private static AllMoves[] possibleMoves = {AllMoves.EMBER, AllMoves.FIRE_PUNCH, AllMoves.FLAMETHROWER, AllMoves.HEAT_WAVE};
    
    public Bulbasaur(String name, int level) {
        super(name, type, Optional.empty(), level, weaknesses, resistances, immunities, (hp + level + 10), atk, def, spAtk, spDef, spe, possibleMoves);    }
}
