package com.griffin.pokemon.moves;

import com.griffin.pokemon.types.Normal;

public class Struggle extends BaseMove implements Normal {
    
    private static final String NAME = "Struggle";
    private static final int BASE_POWER = 50;
    private static final int MAX_POWER = 55;
    private static final int POWER_POINT = 1000;
    private static final double ACCURACY = 100;
    private static final Targets TARGET = Targets.OPPONENT;
    private static final MoveType MOVE_TYPE = MoveType.SPECIAL;
    private static final int PRIORITY = 0;

    public Struggle () {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE, PRIORITY);
    }
}
