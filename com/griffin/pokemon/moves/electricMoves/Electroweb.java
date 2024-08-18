package com.griffin.pokemon.moves.electricMoves;

import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.Targets;
import com.griffin.pokemon.types.Electric;

public class Electroweb extends BaseMove implements Electric {
    
    private static final String NAME = "Electroweb";
    private static final int BASE_POWER = 55;
    private static final int MAX_POWER = 70;
    private static final int POWER_POINT = 15;
    private static final double ACCURACY = 95.00;
    private static final Targets TARGET = Targets.ALL_OPPONENTS;

    public Electroweb () {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET);
    }
}
