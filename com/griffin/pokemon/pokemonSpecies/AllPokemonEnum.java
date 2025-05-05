package com.griffin.pokemon.pokemonSpecies;

public enum AllPokemonEnum {
    FAIL("FAIL"),
    CHARMANDER("CHARMANDER"),
    PIKACHU("PIKACHU"),
    BULBASAUR("BULBASAUR");

    public final String label;

    private AllPokemonEnum(String label) {
        this.label = label;
    }
}
