package com.griffin;
import java.util.Random;
import java.util.Scanner;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.moves.AllMoves;
import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.Struggle;
import com.griffin.pokemon.moves.electricMoves.Electroweb;
import com.griffin.pokemon.moves.electricMoves.MagnetRise;
import com.griffin.pokemon.moves.electricMoves.Spark;
import com.griffin.pokemon.moves.electricMoves.Thunder;
import com.griffin.pokemon.moves.fireMoves.Ember;
import com.griffin.pokemon.moves.fireMoves.FirePunch;
import com.griffin.pokemon.moves.fireMoves.Flamethrower;
import com.griffin.pokemon.moves.fireMoves.HeatWave;

public class PokeFight {
    public int rounds = 0;
    private String move1 = "";
    private String move2 = "";
    private BaseMove baseMove1 = null;
    private BaseMove baseMove2 = null;
    private boolean pokemonOneFirst = false;
    public PokeFight(Pokemon pokemon1, Pokemon pokemon2, Scanner scanner){ 
        while (pokemon1.getCurrentHP() > 0 && pokemon2.getCurrentHP() > 0) {
            //pokemon pick their moves
            rounds ++;
            move1 = pickMove(pokemon1, scanner);
            move2 = pickMove(pokemon2, scanner);
            System.out.println(pokemon1.getName() + " played " + move1);
            System.out.println(pokemon2.getName() + " played " + move2);
            //convert STRING move to BASEMOVE move
            baseMove1 = findMove(move1);
            baseMove2 = findMove(move2);
            //figure who goes first
            if (baseMove1.getPriority() > baseMove2.getPriority()) {
                pokemonOneFirst = true;
            } else if (baseMove2.getPriority() > baseMove1.getPriority()) {
                pokemonOneFirst = false;
            } else {
                if (pokemon1.getSpeStat() > pokemon2.getSpeStat()) {
                    pokemonOneFirst = true;
                } else if (pokemon2.getSpeStat() > pokemon1.getSpeStat()) {
                    pokemonOneFirst = false;
                } else {
                    pokemonOneFirst = new Random().nextBoolean();
                }
            }

                if (pokemonOneFirst) {
                    System.out.println("ONE");
                }else {
                    System.out.println("TWO");  
            } 
        }
    }

    private String pickMove(Pokemon pokemon, Scanner scanner) {
        String move = "";
        do {
            System.out.println("What move do you want " + pokemon.getName() +  " to do?");
            System.out.println(pokemon.getMove1() + ", " + pokemon.getMove2() + ", " + pokemon.getMove3() + ", " + pokemon.getMove4());
            move = scanner.next();
            } while(!move.toLowerCase().equals(pokemon.getMove1().toLowerCase()) && 
                    !move.toLowerCase().equals(pokemon.getMove2().toLowerCase()) && 
                    !move.toLowerCase().equals(pokemon.getMove3().toLowerCase()) && 
                    !move.toLowerCase().equals(pokemon.getMove4().toLowerCase()));
        return move;
    }

    private BaseMove findMove(String move) {
        for (AllMoves index : AllMoves.values()) {
            if (move.equals(index.label.toLowerCase())) {
                return switchMove(index);
            }
        } return new Struggle();
    }

    private BaseMove switchMove(AllMoves move) {
        switch (move) {
            case ELECTROWEB:
                return new Electroweb();
            case MAGNET_RISE: 
                return new MagnetRise();
            case SPARK:
                return new Spark();
            case THUNDER:
                return new Thunder();
            case EMBER:
                return new Ember();
            case FIRE_PUNCH:
                return new FirePunch();
            case FLAMETHROWER:
                return new Flamethrower();
            case HEAT_WAVE:
                return new HeatWave();
            default:
                return new Struggle();
            }
        }
}
