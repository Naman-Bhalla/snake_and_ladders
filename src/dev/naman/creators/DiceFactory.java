package dev.naman.creators;

import dev.naman.models.UniformDice;

public class DiceFactory {
    public static UniformDice.Builder getUniformDice(){
        return new UniformDice.Builder();
    }
}