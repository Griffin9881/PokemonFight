package com.griffin;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.electricMoves.Electroweb;
import com.griffin.pokemon.moves.electricMoves.MagnetRise;
import com.griffin.pokemon.moves.electricMoves.Spark;
import com.griffin.pokemon.moves.electricMoves.Thunder;
import com.griffin.pokemon.moves.fireMoves.Ember;
import com.griffin.pokemon.moves.fireMoves.FirePunch;
import com.griffin.pokemon.moves.fireMoves.Flamethrower;
import com.griffin.pokemon.moves.fireMoves.HeatWave;
import com.griffin.pokemon.moves.AllMoves;

public class SelectMoves {
    public static Pokemon pickMoves(Scanner scanner, Pokemon pokemon) {
        String[] allMovesString = pokemon.getMovesString();
        AllMoves[] allMoves = pokemon.getMoves();
        int numMoves = 0;

        boolean contains = false;
        int k = 0;

        System.out.println("How many moves would you like " + pokemon.getName() + " to learn");
        
        boolean foundInt;
        do {
            try {
                foundInt = false;
                numMoves = scanner.nextInt(); 
            } catch (InputMismatchException e) {
                scanner.next();
                foundInt = true;
            }
        } while (foundInt == true);

        for (int i = 0; i < numMoves; i++) {
            System.out.println("Which move would you like to learn?");

            for (int j = 0; j < allMovesString.length; j++) {
                System.out.print(allMovesString[j] + ", ");
            } 
            System.out.println();

            while (!contains) {
                if (k > 1) {
                    System.out.println("That is not a valid move please pick a valid move");
                }
                String scan = scanner.nextLine();

                for (int j = 0; j < allMovesString.length; j++) {
                    if (allMovesString[j].toLowerCase().equals(scan.toLowerCase())) {
                        scan = null;
                        contains = true;
                        pokemon.learnMove(allMoves[j], scanner);
                        k = 0;
                        break;
                    }
                }
                k++;
            }
            contains = false;
        }
        return pokemon;
    }

    public static BaseMove findMove(AllMoves move, Pokemon target) {
        switch (move) {
            case ELECTROWEB:
                return new Electroweb(target);
            case MAGNET_RISE:
                return new MagnetRise(target);
            case SPARK:
                return new Spark(target);
            case THUNDER:
                return new Thunder(target);
            case EMBER:
                return new Ember(target);
            case FIRE_PUNCH:
                return new FirePunch(target);
            case FLAMETHROWER:
                return new Flamethrower(target);
            case HEAT_WAVE:
                return new HeatWave(target);
            default:
                return new Electroweb(target);
        }
    }

    public static BaseMove oneTimeMove(AllMoves move) {
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
                return new Electroweb();
        }
    }
}
