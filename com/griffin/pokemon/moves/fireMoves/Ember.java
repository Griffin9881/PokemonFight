package com.griffin.pokemon.moves.fireMoves;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.MoveType;
import com.griffin.pokemon.moves.Targets;
import com.griffin.pokemon.types.Fire;

public class Ember extends BaseMove implements Fire {
    
    private static final String NAME = "Ember";
    private static final int BASE_POWER = 40;
    private static final int MAX_POWER = 55;
    private static final int POWER_POINT = 25;
    private static final double ACCURACY = 100.00;
    private static final Targets TARGET = Targets.ALL_POKEMON;
    private static final MoveType MOVE_TYPE = MoveType.SPECIAL;
    private static final int PRIORITY = 0;

    public Ember (Pokemon target) {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE, PRIORITY);
    }

    public Ember () {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE, PRIORITY);
    }
}
