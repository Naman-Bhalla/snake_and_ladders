package dev.naman.models;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UniformDice implements Dice {
    int maxFace;
    public UniformDice(int maxFace) {
        this.maxFace = maxFace;
    }

    private static int getRandomInRange(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    @Override
    public ArrayList<Integer> throwDice() {
        ArrayList<Integer> values = new ArrayList<>();

        int value = -1;
        do{
            value = getRandomInRange(1, this.maxFace);
            values.add(value);
        }while(value==this.maxFace);

        return values;
    }
    
    public static class Builder {
        int maxFace;

        public Builder(){
        }
        
        public Builder setMaxFace(int maxFace){
            this.maxFace = maxFace;
            return this;
        }
        
        public UniformDice build() {

            return new UniformDice(this.maxFace);
        }
   }

}
