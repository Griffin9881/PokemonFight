package com.griffin.pokemon.moves.electricMoves;

import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.Targets;
import com.griffin.pokemon.types.Electric;

public class Thunder extends BaseMove implements Electric {
    
    private static final String NAME = "Thunder";
    private static final int BASE_POWER = 110;
    private static final int MAX_POWER = 130;
    private static final int POWER_POINT = 10;
    private static final double ACCURACY = 70.00;
    private static final Targets TARGET = Targets.ALL_POKEMON;

    public Thunder () {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET);
    }
}
