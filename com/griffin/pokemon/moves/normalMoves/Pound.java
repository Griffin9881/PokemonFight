package com.griffin.pokemon.moves.normalMoves;

import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.MoveType;
import com.griffin.pokemon.moves.Targets;
import com.griffin.pokemon.types.Normal;

public class Pound extends BaseMove implements Normal {
    
    private static final String NAME = "Pound";
    private static final int BASE_POWER = 40;
    private static final int POWER_POINT = 1000;
    private static final double ACCURACY = 100;
    private static final Targets TARGET = Targets.OPPONENT;
    private static final MoveType MOVE_TYPE = MoveType.SPECIAL;
    private static final int PRIORITY = 0;

    public Pound () {
        super(NAME, BASE_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE, PRIORITY, "NORMAL");
    }
}
