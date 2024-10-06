package com.griffin;

public enum Weather {
    RAINY ("Water", "Fire"),
    SUNNY ("Fire", "Water"),
    CLEAR ("", "");

    public final String effectiveType;
    public final String ineffectiveType;

    private Weather(String effectiveType, String ineffectiveType) {
        this.effectiveType = effectiveType;
        this.ineffectiveType = ineffectiveType;
    }

    public String getEffectiveType() {
        return effectiveType;
    }

    public String getIneffectiveType() {
        return ineffectiveType;
    }
}
