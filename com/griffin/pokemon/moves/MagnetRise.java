package com.griffin.pokemon.moves;

import com.griffin.pokemon.types.Electric;

public class MagnetRise extends BaseMove implements Electric {
    
    private static final String NAME = "Magnet Rise";
    private static final int BASE_POWER = 0;
    private static final int MAX_POWER = 0;
    private static final int POWER_POINT = 13;
    private static final double ACCURACY = 100.00;

    public MagnetRise () {
        super(NAME, BASE_POWER, MAX_POWER, POWER_POINT, ACCURACY);
    }
}
