package com.griffin;
import com.griffin.pokemon.Pokemon;

public class PokeFight {
    public PokeFight(Pokemon pokemon1, Pokemon pokemon2){ 
        if (pokemon1.getLevel() > pokemon2.getLevel()) {
            System.out.println(pokemon1.getName() + " Wins!!");
        } else if (pokemon2.getLevel() > pokemon1.getLevel()) {
            System.out.println(pokemon2.getName() + " Wins!!");
        } else {
            System.out.println("It's a tie!!");
        }
    }
}
