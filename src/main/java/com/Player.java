package com;

import lombok.*;

import java.util.ArrayList;



/**
 * 플레이어 객체 모델
 * @author Se-Ok Jeon
 * @version 1.0
 */
@Data
@Builder
public class Player{
    static int idx_of_cur_player = 0;
    static private final int MAXIMUM_NUM_OF_PLAYERS = 2;
    static Player[] players = new Player[MAXIMUM_NUM_OF_PLAYERS];
    static final int ALIVE = 1;
    static final int DEAD = 2;

    private TileType pos;
    private int money ;
    private int energy;
    @Builder.Default
    private Integer power = null;
    @Builder.Default
    private int health = 1;
    @Builder.Default
    private int mental = 1;
    private int dexterity;
    private int intelligence;
    private String characteristics;
    private ArrayList<ItemType> items;
    @Builder.Default
    private int status = ALIVE;

    public void decreaseEnergy() {
        energy--;
    }
    static public Player getCurrentPlayer(){
        return players[idx_of_cur_player];
    }
    static public Player getNextPlayer(){return players[1-idx_of_cur_player];}
    static public Player getPlayer(int idx){return players[idx];}
    static public void toggleCurrentPlayer(){
        idx_of_cur_player = idx_of_cur_player == 1 ? 0: 1;
    }
}
