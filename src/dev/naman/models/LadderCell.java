package dev.naman.models;

public class LadderCell extends Cell {
    Position finalPosition;

    private LadderCell(int cellPoition, int finalPosition) {
        this.position = new Position(cellPoition);
        this.finalPosition = new Position(finalPosition);
    }

    public Position getFinalPosition(){
        return this.finalPosition ;
    }

    public static class Builder {
        int cellPoition;
        int finalPosition;

        public Builder(){}

        public Builder setLowerLadder(int headPosition){
            this.cellPoition = headPosition;
            return this;
        }
        public Builder setUpperLadder(int finalPosition){
            this.finalPosition = finalPosition;
            return this;
        }

        public LadderCell build(){
            return new LadderCell(cellPoition, finalPosition);
        }
    }
}