package com.griffin;

import java.util.Scanner;

import com.griffin.pokemon.pokemonSpecies.AllPokemon;
import com.griffin.pokemon.pokemonSpecies.AllPokemonEnum;

public class FindPokemon {
    private static String[] AllPokemonNames = AllPokemon.AllPokemonNames;
    public static AllPokemonEnum FindThatPokemon(String pokemonAnswer) {
        Scanner scanner = new Scanner(System.in);

        AllPokemonEnum answer = trySwitch(pokemonAnswer);
        while (answer == AllPokemonEnum.FAIL) {
            System.out.println("That is not a valid Pokemon, please pick a pokemon from this list");
                for (int i = 0; i < AllPokemonNames.length; i++) {
                    System.out.print(AllPokemonNames[i] + ", ");
            }
            System.out.println();

            pokemonAnswer = scanner.nextLine();
            answer = trySwitch(pokemonAnswer);
    }
    scanner.close();
    return answer;
}

    public static AllPokemonEnum trySwitch (String pokemonAnswer) {
        try {
            AllPokemonEnum pokemon = AllPokemonEnum.valueOf(pokemonAnswer.toUpperCase());
            switch (pokemon) {
                case AllPokemonEnum.CHARMANDER:
                    return AllPokemonEnum.CHARMANDER;
                case AllPokemonEnum.PIKACHU:
                    return AllPokemonEnum.PIKACHU;
                default:
                    return AllPokemonEnum.FAIL;
            }} catch (IllegalArgumentException e) {   
            System.out.println("Invalid Pokemon!");
        }
        return AllPokemonEnum.FAIL;
    }
}
