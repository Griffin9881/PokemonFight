package com.griffin;

import java.util.Scanner;

import com.griffin.pokemon.Pokemon;

public class Main {
    private static Pokemon pokemon1;
    private static Pokemon pokemon2;
    private static Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) {
        pokemon1 = SelectPokemon.PickPokemon(scanner, 1);
        // pokemon2 = SelectPokemon.PickPokemon(scanner, 2);
        pokemon1 = SelectMoves.pickMoves(scanner, pokemon1);
        System.out.println(pokemon1.getMove1());
        System.out.println(pokemon1.getMove2());
        System.out.println(pokemon1.getMove3());
        System.out.println(pokemon1.getMove4());
        // pokemon2 = SelectMoves.pickMoves(scanner, pokemon2);
        scanner.close();
    }
}
