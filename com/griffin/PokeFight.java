package com.griffin;
import java.util.Scanner;

import com.griffin.pokemon.Pokemon;

public class PokeFight {
    public int rounds = 0;
    private String move1 = "";
    private String move2 = "";
    public PokeFight(Pokemon pokemon1, Pokemon pokemon2, Scanner scanner){ 
        while (pokemon1.getCurrentHP() > 0 && pokemon2.getCurrentHP() > 0) {
            rounds ++;
            move1 = pickMove(pokemon1, scanner);
            move2 = pickMove(pokemon2, scanner);
            System.out.println(pokemon1.getName() + " played " + move1);
            System.out.println(pokemon2.getName() + " played " + move2);
        }
    }

    private String pickMove(Pokemon pokemon, Scanner scanner) {
        String move = "";
        do {
            System.out.println("What move do you want " + pokemon.getName() +  " to do?");
            System.out.println(pokemon.getMove1() + ", " + pokemon.getMove2() + ", " + pokemon.getMove3() + ", " + pokemon.getMove4());
            move = scanner.next();
            } while(!move.toLowerCase().equals(pokemon.getMove1().toLowerCase()) && 
                    !move.toLowerCase().equals(pokemon.getMove2().toLowerCase()) && 
                    !move.toLowerCase().equals(pokemon.getMove3().toLowerCase()) && 
                    !move.toLowerCase().equals(pokemon.getMove4().toLowerCase()));
        return move;
    }
}
