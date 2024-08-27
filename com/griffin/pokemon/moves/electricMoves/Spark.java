package com.griffin.pokemon.moves.electricMoves;

import com.griffin.pokemon.Pokemon;
import com.griffin.pokemon.moves.BaseMove;
import com.griffin.pokemon.moves.MoveType;
import com.griffin.pokemon.moves.Targets;
import com.griffin.pokemon.statusEnums.Conditions;
import com.griffin.pokemon.statusEnums.StatStagesLevels;
import com.griffin.pokemon.statusEnums.Stats;
import com.griffin.pokemon.types.Electric;

public class Spark extends BaseMove implements Electric {
    
    private static final String NAME = "Spark";
    private static final int BASE_POWER = 65;
    private static final int MAX_POWER = 80;
    private static final int POWER_POINT = 20;
    private static final double ACCURACY = 100.00;
    private static final Targets TARGET = Targets.OPPONENT;
    private static final MoveType MOVE_TYPE = MoveType.PHYSICAL;    

    public Spark (Pokemon target) {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE);
        if ((int)(Math.random() * 10 + 1) <= 3) {
            target.gainCondition(Conditions.PARALYSIS);
            target.effectOnStat(StatStagesLevels.minus2, Stats.SPE);
            System.out.println(target.getName() + " has been Paralyzed! They may not be able to move for the next few turns");
        }
    }

    public Spark () {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY, TARGET, MOVE_TYPE);
    }
}
