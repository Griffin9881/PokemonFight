package com.griffin;
import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.moves.BaseMove;

public class PokeFight {
    public int rounds = 0;
    public PokeFight(Pokemon pokemon1, BaseMove move1, Pokemon pokemon2, BaseMove move2){ 
        while (pokemon1.getCurrentHP() > 0 && pokemon2.getCurrentHP() > 0) {
            rounds ++;
        }
    }
}
