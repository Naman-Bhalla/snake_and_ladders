package dev.naman.models;

public class SnakeCell extends Cell {
    Position finalPosition;

    private SnakeCell(int cellPoition, int finalPosition) {
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

        public Builder setHeadPosition(int headPosition){
            this.cellPoition = headPosition;
            return this;
        }
        public Builder setTailPosition(int finalPosition){
            this.finalPosition = finalPosition;
            return this;
        }

        public SnakeCell build(){
            return new SnakeCell(cellPoition, finalPosition);
        }
    }
}


// CellFactory
// CellFactory.createNormalCell().atPositon();
// CellFactory.createCellWithSnake(). withFinalPosition()
// CellFactorycreateCellWithLadder().withFinalPosition()
// CellFactory.createMagicCell().
// Create Implementation SnakeCell, NormalCell, LadderCell
// Make the