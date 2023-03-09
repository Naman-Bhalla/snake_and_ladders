package dev.naman.strategy;

import java.util.ArrayList;

import dev.naman.models.Cell;

public class OnlySnakes implements BoardCreationStrategy {
    int percentCount;
    OnlySnakes(int percentCount){
        this.percentCount = percentCount;
    }
    
    @Override
    public  ArrayList<Cell> createBoard(int boardSize) {
        int snakeCount = (boardSize*this.percentCount)/100;
        
        ArrayList<Cell> cells = new ArrayList<>(boardSize);
        for(int i=0;i<boardSize;i++){
            cells.add(null);
        }
        CellFillingHelper.fillCellWithRandomSnakes(boardSize, snakeCount, cells);
        CellFillingHelper.fillNullCellWithNormal(cells);
        
        return cells;
    }

    public static class Builder {
        int percentCount;
        
        public Builder(){}

        public OnlySnakes withPercent(int numberOfSnakes){
            return new OnlySnakes(numberOfSnakes);
        }
    }
}
