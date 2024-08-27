package com.griffin.pokemon.moves.electricMoves;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.MoveType;
import com.griffin.pokemon.moves.Targets;
import com.griffin.pokemon.statusEnums.StatStagesLevels;
import com.griffin.pokemon.statusEnums.Stats;
import com.griffin.pokemon.types.Electric;

public class Electroweb extends BaseMove implements Electric {
    
    private static final String NAME = "Electroweb";
    private static final int BASE_POWER = 55;
    private static final int MAX_POWER = 70;
    private static final int POWER_POINT = 15;
    private static final double ACCURACY = 95.00;
    private static final Targets TARGET = Targets.ALL_OPPONENTS;
    private static final MoveType MOVE_TYPE = MoveType.SPECIAL;

    public Electroweb (Pokemon target) {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE);
            target.effectOnStat(StatStagesLevels.minus1, Stats.SPE);
    }

    public Electroweb() {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE);
    }
}
