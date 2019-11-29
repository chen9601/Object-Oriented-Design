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
    static public final int ALIVE = 1;
    static public final int DEAD = 2;

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
    static public Player getPlayer(int idx){return players[idx];}
    static public void toggleCurrentPlayer(){
        idx_of_cur_player = idx_of_cur_player == 1 ? 0: 1;
    }

    public void setHealth(int value){
        health = value;
        if(MainGamePageController.maingame_page != null)
            MainGamePageController.update_status(StatusType.HEALTH, health);
    }
    public void setPower(int value){
        power = value;
        if(MainGamePageController.maingame_page != null)
            MainGamePageController.update_status(StatusType.POWER, power);
    }
    public void setMental(int value){
        mental = value;
        if(MainGamePageController.maingame_page != null)
            MainGamePageController.update_status(StatusType.MENTAL, mental);
    }
    public void setEnergy(int value){
        energy = value;
        if(MainGamePageController.maingame_page != null)
            MainGamePageController.update_status(StatusType.ENERGY, energy);
    }
}
