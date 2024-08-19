package com.griffin.pokemon.moves.electricMoves;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.Triggers;
import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.MoveType;
import com.griffin.pokemon.moves.Targets;
import com.griffin.pokemon.types.Electric;

public class MagnetRise extends BaseMove implements Electric {
    //gives user immunity to ground
    private static final String NAME = "Magnet Rise";
    private static final int BASE_POWER = 0;
    private static final int MAX_POWER = 0;
    private static final int POWER_POINT = 13;
    private static final double ACCURACY = 100.00;
    private static final Targets TARGET = Targets.USER;
    private static final MoveType MOVE_TYPE = MoveType.STATUS;

    public MagnetRise (Pokemon target) {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE);
        target.gainImmunity("Ground");
        target.addTrigger(5, Triggers.LOSE_IMMUNITY_GROUND);
    }
}
