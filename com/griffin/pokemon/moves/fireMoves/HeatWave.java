package com.griffin.pokemon.moves.fireMoves;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.MoveType;
import com.griffin.pokemon.moves.Targets;
import com.griffin.pokemon.types.Fire;

public class HeatWave extends BaseMove implements Fire {
    
    private static final String NAME = "Heat Wave";
    private static final int BASE_POWER = 95;
    private static final int MAX_POWER = 120;
    private static final int POWER_POINT = 10;
    private static final double ACCURACY = 90.00;
    private static final Targets TARGET = Targets.ALL_OPPONENTS;
    private static final MoveType MOVE_TYPE = MoveType.SPECIAL;
    private static final int PRIORITY = 0;

    public HeatWave (Pokemon target) {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE, PRIORITY);
    }

    public HeatWave () {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE, PRIORITY);
    }
}
