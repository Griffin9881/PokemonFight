package com.griffin.pokemon.pokemonSpecies.firePokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.moves.AllMoves;
import com.griffin.pokemon.types.Fire;

public class Charmander extends Pokemon implements Fire {
    private static String type = "Fire";
    private static int hp = 35;
    private static int atk = 55;
    private static int def = 40;
    private static int spAtk = 50;
    private static int spDef = 50;
    private static int spe = 90;
    private static ArrayList<String> weaknesses = new ArrayList<>(Arrays.asList(Fire.weaknesses));
    private static ArrayList<String> resistances = new ArrayList<>(Arrays.asList(Fire.weaknesses));
    private static ArrayList<String> immunities = new ArrayList<>(Arrays.asList(Fire.weaknesses));
    private static AllMoves[] possibleMoves = {AllMoves.EMBER, AllMoves.FIRE_PUNCH, AllMoves.FLAMETHROWER, AllMoves.HEAT_WAVE};
    
    public Charmander(String name, int level) {
        super(name, type, Optional.empty(), level, weaknesses, resistances, immunities, (hp + level + 10), atk, def, spAtk, spDef, spe, possibleMoves);    }
}
