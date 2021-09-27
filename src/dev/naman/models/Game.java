package dev.naman.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Game {
    int boardSize;
    Board board;
    Queue<Player> players;
    Map<Player, Integer> ranks; // map of ranks of players. if player hasn't received rank yet, they are -1

   private Game(int boardSize, List<Player> players) {
           this.boardSize = boardSize;
           this.board = null;///
           this.players = null;
           this.ranks = null;
   }

   static class Builder {

       void build() {
           Game game = new Game(100, new ArrayList<>());
           Board b = new Board(this.boardSize);
       }
   }
}

// Game(100, {p1, p2, p3, p4})
/// 5% -> Config
// Avoid new as much as possible for your clients
// TODO
// Create a builder
// GameBuilder.buildGame().
// addPlayer().
// addPlayer().
// addPlayer().
// setBoardSize()
// .build();

// If I am having an API for public, favour builders as much as possible
// If there are classes that are being used within my CB, then constructors are okay