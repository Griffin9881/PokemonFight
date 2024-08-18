package com.griffin.pokemon.statusEnums;

public enum StatStagesLevels {
    plus6(12),
    plus5(11),
    plus4(10),
    plus3(9),
    plus2(8),
    plus1(7),
    normal(6),
    minus1(5),
    minus2(4),
    minus3(3),
    minus4(2),
    minus5(1),
    minus6(0);

    public final int label;

    private StatStagesLevels(int label) {
        this.label = label;
    }
}