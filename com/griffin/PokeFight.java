package com.griffin;
import java.util.Scanner;

import com.griffin.pokemon.Pokemon;

public class PokeFight {
    public int rounds = 0;
    public PokeFight(Pokemon pokemon1, Pokemon pokemon2, Scanner scanner){ 
        while (pokemon1.getCurrentHP() > 0 && pokemon2.getCurrentHP() > 0) {
            rounds ++;
            
        }
    }
}
