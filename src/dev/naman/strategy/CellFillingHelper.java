package dev.naman.strategy;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import dev.naman.common.Constants;
import dev.naman.models.Cell;
import dev.naman.models.LadderCell;
import dev.naman.models.NormalCell;
import dev.naman.models.SnakeCell;

public class CellFillingHelper {
    public static int getRandomInRange(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    
    public static void fillCellWithRandomSnakes(int boardSize, int count, ArrayList<Cell> cells){
        while (count>0) {
            int tailPosition = getRandomInRange(Constants.PLAYER_START_POSITION+1, boardSize-Constants.SNAKE_MIN_LENGTH-1);
            int headPosition = getRandomInRange(tailPosition+Constants.SNAKE_MIN_LENGTH, boardSize-1);
            
            if(cells.get(headPosition) == null){
                SnakeCell snakeCell = new SnakeCell.Builder()
                    .setHeadPosition(headPosition)
                    .setTailPosition(tailPosition)
                    .build();
                cells.set(headPosition, snakeCell);
                count--;
            }
        }
    }

    public static void fillCellWithRandomLadders(int boardSize, int count, ArrayList<Cell> cells){
        while (count>0) {
            int lowerLadder = getRandomInRange(Constants.PLAYER_START_POSITION+1, boardSize-Constants.LADDER_MIN_LENGTH-1);
            int upperLadder = getRandomInRange(lowerLadder+Constants.LADDER_MIN_LENGTH, boardSize-1);
            
            if(cells.get(lowerLadder) == null){
                LadderCell snakeCell = new LadderCell.Builder()
                    .setLowerLadder(lowerLadder)
                    .setUpperLadder(upperLadder)
                    .build();
                cells.set(lowerLadder, snakeCell);
                count--;
            }
        }
    }

    public static void fillNullCellWithNormal(ArrayList<Cell> cells){
        for(int i=0;i<cells.size();i++){
            if(cells.get(i) == null){
                cells.set(i, new NormalCell.Builder().setCellPosition(i+1).build());
            }
        }
    }

}
