package com;

import GUI.MainGame_page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class MainGamePageController {
    static public MainGame_page maingame_page;
    static public JButton[] dot_array;
    static public JLabel[] player1_array;
    static public JLabel[] player2_array;

    public MainGamePageController(){
        maingame_page = new MainGame_page();
        dot_array = maingame_page.getBtn_reddot_array();
        player1_array = maingame_page.getLb_player1_array();
        player2_array = maingame_page.getLb_player2_array();
        MainGamePageController.show_players();
        maingame_page.setVisible(true);
    }

    public static void update_token(int value){
        maingame_page.getTab().getToken_text().setText(Integer.toString(value));
    }

    public static void update_status(StatusType type, int value){
        // TODO : Need refactoring. uncomfortable
        if(Player.idx_of_cur_player == 0)
            maingame_page.getPlayer1_status_panel().getStatus_details()[type.ordinal()]
                    .getAttribute_textpane().setText(Integer.toString(value));
        else
            maingame_page.getPlayer2_status_panel().getStatus_details()[type.ordinal()]
                    .getAttribute_textpane().setText(Integer.toString(value));
    }

    public static void show_reddot() {
        ArrayList<TileType> movable_tiles = Map.getMovableTiles(Player.getCurrentPlayer());
        for (TileType movable_tile : movable_tiles) {
            dot_array[movable_tile.ordinal()].setVisible(true);
            dot_array[movable_tile.ordinal()].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Clicked " + movable_tile.ordinal());
                    ConstantEventHandler.move(Player.getCurrentPlayer(), movable_tile);
                    // 모든 빨간 점을 보이지 않게 만들기
                    for(JButton reddot : dot_array){
                        reddot.setVisible(false);
                    }
                    GameMaster.monster_fightcondition();
                    System.out.println("passed monsterfightpage");
                    show_players();
                }
            });
        }
    }

    public static void show_players() {
        for (JLabel label : player2_array) {
            label.setVisible(false);
        }
        for (JLabel label : player1_array) {
            label.setVisible(false);
        }
        player1_array[Player.getPlayer(0).getPos().ordinal()].setVisible(true);
        player2_array[Player.getPlayer(1).getPos().ordinal()].setVisible(true);
    }

}
