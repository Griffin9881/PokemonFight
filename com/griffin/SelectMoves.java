package com.griffin;

import java.util.Scanner;

import com.griffin.pokemon.Pokemon;

public class SelectMoves {
    public static Pokemon pickMoves(Scanner scanner, Pokemon pokemon) {
        // System.out.println(pokemon.getMoves());
        while (!scanner.hasNextInt()) {
            System.out.println("How many moves would you like to learn");
            scanner.nextLine();
        }
        int numMoves = scanner.nextInt();

        for (int i = 0; i < numMoves; i++) {
            System.out.println("Which move would you like to learn first?");
            System.out.println(pokemon.getMoves());
        }
        return pokemon;
    }
}
