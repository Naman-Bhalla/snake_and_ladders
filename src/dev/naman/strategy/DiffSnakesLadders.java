package dev.naman.strategy;

import java.util.ArrayList;

import dev.naman.models.Cell;

public class DiffSnakesLadders implements BoardCreationStrategy {
    private int ladderPercent;
    private int snakePercent;
    DiffSnakesLadders(int snakePercent, int ladderPercent){
        this.snakePercent = snakePercent;
        this.ladderPercent = ladderPercent;
        
    }
    
    @Override
    public ArrayList<Cell> createBoard(int boardSize) {
        int snakeCount = (boardSize*this.snakePercent)/100;
        int ladderCount = (boardSize*this.ladderPercent)/100;
        
        ArrayList<Cell> cells = new ArrayList<>(boardSize);
        for(int i=0;i<boardSize;i++){
            cells.add(null);
        }
        CellFillingHelper.fillCellWithRandomSnakes(boardSize, snakeCount, cells);
        CellFillingHelper.fillCellWithRandomLadders(boardSize, ladderCount, cells);
        CellFillingHelper.fillNullCellWithNormal(cells);

        return cells;
    }


    public static class Builder {
        int ladderPercent;
        int snakePercent;
        
        
        public Builder(){}
        
        public Builder withLadderPercent(int ladderPercent){
            this.ladderPercent = ladderPercent;
            return this;
        }

        public Builder withSnakePercent(int snakePercent){
            this.snakePercent = snakePercent;
            return this;
        }

        public DiffSnakesLadders build(){
            return new DiffSnakesLadders(this.snakePercent, this.ladderPercent);
        }
    }
}



// BopardCreationStrategyFactory.forDifferentSnakesAndLadders()
//. withSnakePercent(5)
// .withLadderPercent(3)
// .ofBoardSzize(100)
// ./validateAndBuild();