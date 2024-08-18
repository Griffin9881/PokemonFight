package com.griffin.pokemon.moves.fireMoves;

import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.Targets;
import com.griffin.pokemon.types.Fire;

public class Flamethrower extends BaseMove implements Fire {
    
    private static final String NAME = "Flamethrower";
    private static final int BASE_POWER = 90;
    private static final int MAX_POWER = 105;
    private static final int POWER_POINT = 15;
    private static final double ACCURACY = 100.00;
    private static final Targets TARGET = Targets.ALL_POKEMON;

    public Flamethrower () {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET);
    }
}
