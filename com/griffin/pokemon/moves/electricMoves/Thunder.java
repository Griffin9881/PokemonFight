package com.griffin.pokemon.moves.electricMoves;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.MoveType;
import com.griffin.pokemon.moves.Targets;
import com.griffin.pokemon.statusEnums.Conditions;
import com.griffin.pokemon.statusEnums.StatStagesLevels;
import com.griffin.pokemon.statusEnums.Stats;
import com.griffin.pokemon.types.Electric;

public class Thunder extends BaseMove implements Electric {
    
    private static final String NAME = "Thunder";
    private static final int BASE_POWER = 110;
    private static final int MAX_POWER = 130;
    private static final int POWER_POINT = 10;
    private static final double ACCURACY = 70.00;
    private static final Targets TARGET = Targets.ALL_POKEMON;
    private static final MoveType MOVE_TYPE = MoveType.SPECIAL;

    public Thunder (Pokemon target) {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE);
        if ((int)(Math.random() * 10 + 1) <= 3 && target.getType1() != "Electric" && target.getType2() != "Electric") {
            target.gainCondition(Conditions.PARALYSIS);
            target.effectOnStat(StatStagesLevels.minus2, Stats.SPE);
            System.out.println(target.getName() + " has been Paralyzed! They may not be able to move for the next few turns");
        }
    }

    public Thunder () {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE);
    }
}
