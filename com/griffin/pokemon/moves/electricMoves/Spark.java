package com.griffin.pokemon.moves.electricMoves;

import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.Targets;
import com.griffin.pokemon.types.Electric;

public class Spark extends BaseMove implements Electric {
    
    private static final String NAME = "Spark";
    private static final int BASE_POWER = 65;
    private static final int MAX_POWER = 80;
    private static final int POWER_POINT = 20;
    private static final double ACCURACY = 100.00;
    private static final Targets TARGET = Targets.OPPONENT;

    public Spark () {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET);
    }
}
