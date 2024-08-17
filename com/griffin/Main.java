package com.griffin;

import com.griffin.pokemon.Pokemon;

public class Main {
    private static Pokemon bulbasaur = new Pokemon("Bulbasaur", 5);
    private static Pokemon litwick = new Pokemon("Litwick", 10);
        public static void main(String[] args) {
        System.out.println("Name: " + bulbasaur.getName());
        new PokeFight(bulbasaur, litwick);
    }
}
