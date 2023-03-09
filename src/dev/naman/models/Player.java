package dev.naman.models;

import dev.naman.common.PlayerStatus;

public class Player {
    Position position;
    User user; // int user_id; // lazy load
    PlayerStatus status;

    Player(User user, Position position, PlayerStatus status){
        this.user = user;
        this.position = position;
        this.status = status;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public PlayerStatus getStatus() {
        return this.status;
    }

    public String getName() {
        return this.user.username;
    }
}
