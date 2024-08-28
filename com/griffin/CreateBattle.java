package com.griffin;

import java.util.Scanner;

import com.griffin.pokemon.Pokemon;

public class CreateBattle {
    private Pokemon pokemon1;
    private static Pokemon pokemon2;
    private static Scanner scanner = new Scanner(System.in);

    public CreateBattle() {
        pokemon1 = SelectPokemon.PickPokemon(scanner, 1);
        pokemon2 = SelectPokemon.PickPokemon(scanner, 2);
        pokemon1 = SelectMoves.pickMoves(scanner, pokemon1);
        pokemon2 = SelectMoves.pickMoves(scanner, pokemon2);
        scanner.close();
    }
}
