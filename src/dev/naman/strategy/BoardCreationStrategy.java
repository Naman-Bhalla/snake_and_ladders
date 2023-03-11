package dev.naman.strategy;

import java.util.ArrayList;
import dev.naman.models.Cell;

public interface BoardCreationStrategy {
    ArrayList<Cell> createBoard(int boardSize);
}