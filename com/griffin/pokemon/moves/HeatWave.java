package com.griffin.pokemon.moves;

import com.griffin.pokemon.types.Fire;

public class HeatWave extends BaseMove implements Fire {
    
    private static final String NAME = "Heat Wave";
    private static final int BASE_POWER = 95;
    private static final int MAX_POWER = 120;
    private static final int POWER_POINT = 10;
    private static final int ACCURACY = 90;

    public HeatWave () {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY);
    }
}
