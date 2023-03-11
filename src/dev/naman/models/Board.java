package dev.naman.models;

import dev.naman.strategy.BoardCreationStrategy;

import java.util.ArrayList;

public class Board {
    ArrayList<Cell> cells;
    BoardCreationStrategy strategy;

    Board(int boardSize, BoardCreationStrategy strategy) {
        this.strategy = strategy;
        this.cells = strategy.createBoard(boardSize);
    }

    public int getBoardSize(){
        return cells.size();
    }

    public Position moveAt(int cellNumber) {
        // cellNumber -1 because arraylist has 0 index cells
        return cells.get(cellNumber-1).getFinalPosition();
    }

    public static class Builder {

        int boardSize;
        BoardCreationStrategy strategy;

        public Builder(){
        }

        public Builder setBoardSize(int boardSize){
            this.boardSize = boardSize;
            return this;
        }

        public Builder setStrategy(BoardCreationStrategy strategy){
            this.strategy = strategy;
            return this;
        }
        
        public Board build() {
            return new Board(this.boardSize, this.strategy);
        }
   }
}
