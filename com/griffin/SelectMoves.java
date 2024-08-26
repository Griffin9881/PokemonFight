package com.griffin;

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
        AllMoves move;

        boolean contains = false;
        int k = 0;

        System.out.println("How many moves would you like to learn");
        int numMoves = scanner.nextInt();

        for (int i = 0; i < numMoves; i++) {
            System.out.println("Which move would you like to learn first?");

            for (int j = 0; j < allMovesString.length; j++) {
                System.out.print(allMovesString[j] + ", ");
            } 
            System.out.println();

            while (!contains) {
                if (k > 0) {
                    System.out.println("That is not a valid move please pick a valid move");
                    for (int j = 0; j < allMovesString.length; j++) {
                        System.out.print(allMovesString[j] + ", ");
                    } 
                    System.out.println();
                }
                
                String scan = scanner.nextLine();

                for (int j = 0; j < allMovesString.length; j++) {
                    if (allMovesString[i].equals(scan)) {
                        contains = true;
                        move = allMoves[i];
                        break;
                    }
                }
            }
            pokemon.learnMove(null, move, scanner);
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
                return new FirePunch();
            case FLAMETHROWER:
                return new Flamethrower();
            case HEAT_WAVE:
                return new HeatWave();
            default:
                return new Electroweb(target);
        }
    }
}
