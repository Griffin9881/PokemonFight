package com.griffin.pokemon.statusEnums;

public enum StatStages {
    plus6(4.0),
    plus5(3.5),
    plus4(3.0),
    plus3(2.5),
    plus2(2.0),
    plus1(1.5),
    normal(1.0),
    minus1(0.66),
    minus2(0.50),
    minus3(0.40),
    minus4(0.33),
    minus5(0.28),
    minus6(0.25);

    public final double label;

    private StatStages(Double label) {
        this.label = label;
    }
}