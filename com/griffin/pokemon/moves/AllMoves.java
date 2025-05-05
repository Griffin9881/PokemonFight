package com.griffin.pokemon.moves;

public enum AllMoves {
    ELECTROWEB ("Electroweb"),
    MAGNET_RISE ("Magnet Rise"),
    SPARK ("Spark"),
    THUNDER ("Thunder"),
    EMBER ("Ember"),
    FIRE_PUNCH ("Fire Punch"),
    FLAMETHROWER ("Flamethrower"),
    HEAT_WAVE ("Heat Wave");

    public final String name;

    private AllMoves(String name) {
        this.name = name;
    }
}
