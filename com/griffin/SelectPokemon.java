package com.griffin;

import java.util.Scanner;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.pokemonSpecies.AllPokemon;
import com.griffin.pokemon.pokemonSpecies.AllPokemonEnum;
import com.griffin.pokemon.pokemonSpecies.electricPokemon.Pikachu;
import com.griffin.pokemon.pokemonSpecies.firePokemon.Charmander;

public class SelectPokemon {
    private static Pokemon pokemon;
    private static String[] AllPokemonNames = AllPokemon.AllPokemonNames;
    public static Pokemon PickPokemon(Scanner scanner, int player) {
        if (player == 1) {
            System.out.println("What is the first pokemon?");
            String pokemonAnswer = scanner.nextLine();
            System.out.println("What level do you want your pokemon to be?");
            String levelAnswer = scanner.nextLine();
            int level = Integer.parseInt(levelAnswer);

            AllPokemonEnum answer = FindThatPokemon(pokemonAnswer, scanner);
            switch (answer) {
                case CHARMANDER:
                pokemon = new Charmander("Charmander", level);
                break;
            case PIKACHU:
                pokemon = new Pikachu("Pikachu", level);
                break;
            default:
                break;
        }
    } else {
        String pokemonAnswer2 = "";
        int levelAnswer2 = 0;
        System.out.println("What is the other pokemon?");
        pokemonAnswer2 = scanner.nextLine();
        System.out.println(pokemonAnswer2);
        System.out.println("What level do you want your pokemon to be?");
        levelAnswer2 = Integer.parseInt(scanner.nextLine());

        AllPokemonEnum answer2 = FindThatPokemon(pokemonAnswer2, scanner);
        switch (answer2) {
            case CHARMANDER:
                pokemon = new Charmander("Charmander", levelAnswer2);
                break;
            case PIKACHU:
                pokemon = new Pikachu("Pikachu", levelAnswer2);
            default:
                break;
            }
        }
        return pokemon;
    }

    public static AllPokemonEnum FindThatPokemon(String pokemonAnswer, Scanner scanner) {
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
                case CHARMANDER:
                    return AllPokemonEnum.CHARMANDER;
                case PIKACHU:
                    return AllPokemonEnum.PIKACHU;
                default:
                    return AllPokemonEnum.FAIL;
            }} catch (IllegalArgumentException e) {   
            System.out.println("Invalid Pokemon!");
        }
        return AllPokemonEnum.FAIL;
    }
}
