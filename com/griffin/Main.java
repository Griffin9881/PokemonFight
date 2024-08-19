package com.griffin;

import java.util.Scanner;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.pokemonSpecies.AllPokemon;
import com.griffin.pokemon.pokemonSpecies.AllPokemonEnum;
import com.griffin.pokemon.pokemonSpecies.electricPokemon.Pikachu;
import com.griffin.pokemon.pokemonSpecies.firePokemon.Charmander;

public class Main {
    private static Pokemon pokemon1;
    private static Pokemon pokemon2;
    private static Scanner scanner = new Scanner(System.in);
    private static String[] AllPokemonNames = AllPokemon.AllPokemonNames;
            public static void main(String[] args) {

        System.out.println("What is the first pokemon?");
        String pokemonAnswer = scanner.nextLine();
        System.out.println("What level do you want your pokemon to be?");
        String levelAnswer = scanner.nextLine();
        int level = Integer.parseInt(levelAnswer);

        AllPokemonEnum answer = FindThatPokemon(pokemonAnswer);
        switch (answer) {
            case AllPokemonEnum.CHARMANDER:
                pokemon1 = new Charmander("Charmander", level);
                break;
            case AllPokemonEnum.PIKACHU:
                pokemon1 = new Pikachu("Pikachu", level);
            default:
                break;
        }

        String pokemonAnswer2 = "";
        int levelAnswer2 = 0;
        System.out.println("What is the other pokemon?");
        pokemonAnswer2 = scanner.nextLine();
        System.out.println(pokemonAnswer2);
        System.out.println("What level do you want your pokemon to be?");
        levelAnswer2 = Integer.parseInt(scanner.nextLine());

        AllPokemonEnum answer2 = FindThatPokemon(pokemonAnswer2);
        switch (answer2) {
            case AllPokemonEnum.CHARMANDER:
                pokemon2 = new Charmander("Charmander", levelAnswer2);
                break;
            case AllPokemonEnum.PIKACHU:
                pokemon2 = new Pikachu("Pikachu", levelAnswer2);
            default:
                break;
        }
        scanner.close();
    }

    public static AllPokemonEnum FindThatPokemon(String pokemonAnswer) {
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
