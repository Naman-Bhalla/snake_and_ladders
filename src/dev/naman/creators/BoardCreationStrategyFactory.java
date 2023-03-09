package dev.naman.creators;

import dev.naman.strategy.EqualSnakesAndLadders;
import dev.naman.strategy.OnlySnakes;

public class BoardCreationStrategyFactory {
    public static OnlySnakes.Builder getWithOnlySnakes(){
        return new OnlySnakes.Builder();
    }

    public static EqualSnakesAndLadders.Builder getWithEqualSnakeAndLadder(){
        return new EqualSnakesAndLadders.Builder();
    }

}