package com.griffin.pokemon.pokemonSpecies;

public enum AllPokemonEnum {
    FAIL("FAIL"),
    CHARMANDER("CHARMANDER"),
    PIKACHU("PIKACHU");

    public final String label;

    private AllPokemonEnum(String label) {
        this.label = label;
    }
}
