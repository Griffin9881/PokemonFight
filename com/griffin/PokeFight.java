package com.griffin;
import java.util.Random;
import java.util.Scanner;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.moves.AllMoves;
import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.MoveType;
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
    private Weather weather = Weather.CLEAR;
    private FieldStatus fieldStatus = FieldStatus.CLEAR;

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
            figurePriority(pokemon1, baseMove1, pokemon2, baseMove2);
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

    private void figurePriority(Pokemon pokemon1, BaseMove move1, Pokemon pokemon2, BaseMove move2) {
        if (move1.getPriority() > move2.getPriority()) {
                pokemonOneFirst = true;
            } else if (move2.getPriority() > move1.getPriority()) {
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
    }

    private void figureDamage(Pokemon pokemon1, Pokemon pokemon2, BaseMove move, MoveType moveType) {
        int random = (int)Math.random() *100;
        int critMult = 1;
        int atk = 1;
        int def = 1;
        int power = move.getBasePower();
        int level = pokemon1.getLevel();
        int item = 1;
        double weatherMult = 1;
        double STABMult = 1;
        double typeMult = 1;

        if (random <= 4) {
            critMult = 2;
        }

        System.out.println(critMult);
        switch (moveType) {
            case PHYSICAL:
                atk = pokemon1.getAtkStat();
                def = pokemon2.getDefStat();
                break;
            case SPECIAL:
                atk = pokemon1.getSpAtkStat();
                def = pokemon2.getSpDefStat();
                break;
            default: 
                break;
        }

        if (pokemon1.getType1().toLowerCase().equals(weather.getEffectiveType().toLowerCase()) ||
                pokemon1.getType2().toLowerCase().equals(weather.effectiveType.toLowerCase())) {
            weatherMult = 1.5;
        } else if (pokemon1.getType1().toLowerCase().equals(weather.getIneffectiveType().toLowerCase()) ||
                pokemon1.getType2().toLowerCase().equals(weather.ineffectiveType.toLowerCase())) {
            weatherMult = 0.5;
        }

        if (move.getType().toLowerCase().equals(pokemon1.getType1().toLowerCase()) ||
                move.getType().toLowerCase().equals(pokemon1.getType2().toLowerCase())) {
            typeMult = 1.5;
        }

        double damage = ((2 * level / 5 + 2) * power * atk / def / 50) * item * critMult * STABMult * weatherMult * typeMult;
    }
}
