package com.griffin;
import java.util.Scanner;

import com.griffin.pokemon.Pokemon;

public class PokeFight {
    public int rounds = 0;
    public PokeFight(Pokemon pokemon1, Pokemon pokemon2, Scanner scanner){ 
        String move1 = "";
        String move2 = "";
        while (pokemon1.getCurrentHP() > 0 && pokemon2.getCurrentHP() > 0) {
            rounds ++;
            
            do {
            System.out.println("What move do you want your first pokemon to do?");
            System.out.println(pokemon1.getMove1() + ", " + pokemon1.getMove2() + ", " + pokemon1.getMove3() + ", " + pokemon1.getMove4());
            move1 = scanner.next();
            } while(!move1.toLowerCase().equals(pokemon1.getMove1()) && !move1.toLowerCase().equals(pokemon1.getMove2()) && !move1.toLowerCase().equals(pokemon1.getMove3()) && !move1.toLowerCase().equals(pokemon1.getMove4()));

            do {
            System.out.println("What move do you want the other pokemon to do?");
            System.out.println(pokemon2.getMove1() + ", " + pokemon2.getMove2() + ", " + pokemon2.getMove3() + ", " + pokemon2.getMove4());
            move2 = scanner.next();
            } while(!move2.toLowerCase().equals(pokemon2.getMove1()) && !move2.toLowerCase().equals(pokemon2.getMove2()) && !move2.toLowerCase().equals(pokemon2.getMove3()) && !move2.toLowerCase().equals(pokemon2.getMove4()));

            System.out.println(move1);
            System.out.println(move2);
        }
    }
}
