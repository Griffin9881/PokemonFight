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

    public final String label;

    private AllMoves(String label) {
        this.label = label;
    }
}
