package dev.naman.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import dev.naman.common.Constants;
import dev.naman.common.PlayerStatus;

public class Game {
    Board board;
    Queue<Player> players;
    Map<Player, Integer> ranks; // map of ranks of players. if player hasn't received rank yet, they are -1
    Dice dice;

   private Game(Board board, List<Player> players, Dice dice) {
        this.players = new LinkedList<Player>(players);
        this.ranks = new HashMap<>();
        this.board = board;
        this.dice = dice;
   }

   private void movePlayer(Player player) {
        ArrayList<Integer> values = dice.throwDice();

        for(int value: values){

            int newIndex = player.position.cellNumber + value;

            if(newIndex > board.getBoardSize()){
                // will go out of board
                break;
            }

            Position finalPosition = board.moveAt(newIndex);
            player.setPosition(finalPosition);

            // new cell can be a special cell so continue moving
            while(true){
                Position newPosition = this.board.moveAt(player.position.cellNumber);
                if(newPosition.cellNumber == player.position.cellNumber){
                    break;
                }
                player.setPosition(newPosition);
            }
        }

        if(player.position.cellNumber == board.getBoardSize()){
            player.setStatus(PlayerStatus.COMPLETED);
        }
   }

   public void run(){
        while (this.players.size()>1) {
            Player currentPlayer = this.players.remove();
            movePlayer(currentPlayer);
            
            if(currentPlayer.getStatus() == PlayerStatus.IN_PROGRESS){
                this.players.add(currentPlayer);
            } else if(currentPlayer.getStatus() == PlayerStatus.COMPLETED){
                this.ranks.put(currentPlayer, this.ranks.size()+1);
            }
        }

        Player lastPlayer = this.players.remove();
        lastPlayer.setStatus(PlayerStatus.LOOSE);
        this.ranks.put(lastPlayer, ranks.size()+1);
   }

   public ArrayList<Player> getLeaderBoard() {
        ArrayList<Player> leaderBoard = new ArrayList<>(this.ranks.size());
        for(int i=this.ranks.size();i>=1;i--){
            leaderBoard.add(null);
        }

        for(Map.Entry<Player, Integer> entry: this.ranks.entrySet()){
            Player player = entry.getKey();
            Integer rank = entry.getValue();

            leaderBoard.set(rank-1, player);
        }

        return leaderBoard;
   }

   public static class Builder {
        Board board;
        List<Player> players;
        Dice dice;

        public Builder(){
            players = new ArrayList<>();
        }

        public Builder addUser(User user){
            this.players.add(new Player(user, new Position(Constants.PLAYER_START_POSITION), PlayerStatus.IN_PROGRESS));
            return this;
        }
        
        public Builder setBoard(Board board){
            this.board = board;
            return this;
        }
        
        public Builder setDice(Dice dice) {
            this.dice = dice;
            return this;
        }

        public Game build() {
            Game game = new Game(this.board, this.players, this.dice);
            return game;
        }
   }
}

// Game(100, {p1, p2, p3, p4})
/// 5% -> Config
// Avoid new as much as possible for your clients
// Create a builder
// GameBuilder.buildGame().
// addPlayer().
// addPlayer().
// addPlayer().
// setBoardSize()
// .build();

// If I am having an API for public, favour builders as much as possible
// If there are classes that are being used within my CB, then constructors are okay