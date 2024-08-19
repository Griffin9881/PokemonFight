package com.griffin;

import java.util.Scanner;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.pokemonSpecies.AllPokemonEnum;
import com.griffin.pokemon.pokemonSpecies.electricPokemon.Pikachu;
import com.griffin.pokemon.pokemonSpecies.firePokemon.Charmander;

public class Main {
    private static Pokemon pokemon1;
    private static Pokemon pokemon2;
            public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the first pokemon?");
        String pokemonAnswer = scanner.nextLine();
        System.out.println("What level do you want your pokemon to be?");
        int levelAnswer = Integer.parseInt(scanner.nextLine());
        scanner.close();

        AllPokemonEnum answer = FindPokemon.FindThatPokemon(pokemonAnswer);
        switch (answer) {
            case AllPokemonEnum.CHARMANDER:
                pokemon1 = new Charmander("Charmander", levelAnswer);
                break;
            case AllPokemonEnum.PIKACHU:
                pokemon1 = new Pikachu("Pikachu", levelAnswer);
            default:
                break;
        }

        scanner = new Scanner(System.in);
        System.out.println("What is the other pokemon?");
        String pokemonAnswer2 = scanner.nextLine();
        System.out.println(pokemonAnswer2);
        System.out.println("What level do you want your pokemon to be?");
        int levelAnswer2 = Integer.parseInt(scanner.nextLine());

        AllPokemonEnum answer2 = FindPokemon.FindThatPokemon(pokemonAnswer2);
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
}
