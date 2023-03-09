package dev.naman.models;

public class NormalCell extends Cell {

    private NormalCell(int position){
        this.position = new Position(position);
    }

    public Position getFinalPosition(){
        return this.position;
    }

    public static class Builder {
        int cellPoition;

        public Builder(){}

        public Builder setCellPosition(int position){
            this.cellPoition = position;
            return this;
        }

        public NormalCell build(){
            return new NormalCell(cellPoition);
        }
    }
}
