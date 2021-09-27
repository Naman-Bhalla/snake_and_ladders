package dev.naman.models;

import dev.naman.strategy.BoardCreationStrategy;

import java.util.ArrayList;
import java.util.List;

public class Board {
    ArrayList<Cell> cells;
    BoardCreationStrategy strategy;

    Board(int boardSize) {
        this.cells = strategy.createBoard().cells;
    }
}
