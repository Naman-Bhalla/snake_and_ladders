package dev.naman;

import java.util.ArrayList;

import dev.naman.creators.BoardCreationStrategyFactory;
import dev.naman.creators.DiceFactory;
import dev.naman.models.Board;
import dev.naman.models.Game;
import dev.naman.models.Player;
import dev.naman.models.User;

public class Client {

    public static void main(String[] args) {
        User user1 = new User("Elon");
        User user2 = new User("Jef");
        User user3 = new User("Gates");

        Board board = new Board.Builder()
            .setBoardSize(100)
            .setStrategy(BoardCreationStrategyFactory.getWithEqualSnakeAndLadder().withPercent(5).build())
            .build();
        
        Game game = new Game.Builder()
            .addUser(user1)
            .addUser(user2)
            .addUser(user3)
            .setBoard(board)
            .setDice(DiceFactory.getUniformDice().setMaxFace(6).build())
            .build();
        
        game.run();
        ArrayList<Player> leaderBoard = game.getLeaderBoard();
        
        System.out.println("Rank\tName");
        for(int i=0;i<leaderBoard.size();i++){
            System.out.println((i+1) + "\t" + leaderBoard.get(i).getName());
        }

    }
}

// models -> entities
// utilities
// strategies
// factories