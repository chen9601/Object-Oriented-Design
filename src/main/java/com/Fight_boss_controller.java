package com;

import GUI.Fight_boss_page;
import GUI.MainGame_page;

import java.util.Timer;
import java.util.TimerTask;

public class Fight_boss_controller {
    public static Fight_boss_page fight_boss_page;

    public Fight_boss_controller(){
        fight_boss_page = new Fight_boss_page();
        fight_boss_page.setVisible(true);
    }

    public static void attackedPlayerByBoss() {

        Player player = Player.getCurrentPlayer();
        int temp2 = ConstantEventHandler.Dice();
        Boss boss = GameMaster.current_boss;
        if (temp2 > boss.getRequireVal()) {
            player.setHealth(player.getHealth() - boss.getDamage());
            if(player == Player.getPlayer(0)){
                Fight_boss_page.player1_status_panel.getStatus_details()[StatusType.HEALTH.ordinal()].getAttribute_textpane().setText(Integer.toString(player.getHealth()));
            }
            else{
                Fight_boss_page.player2_status_panel.getStatus_details()[StatusType.HEALTH.ordinal()].getAttribute_textpane().setText(Integer.toString(player.getHealth()));
            }
        }
    }

    public static void attackedBossByPlayer() {

        int dice_value = ConstantEventHandler.Dice();
        Boss boss = GameMaster.current_boss;
        if (dice_value > boss.getRequireVal()) {
            boss.setHealth(boss.getHealth() - (dice_value - boss.getRequireVal()));
            Fight_boss_page.boss_temphealth.setText(Integer.toString(boss.getHealth()));
        }
    }

    public static void checkWhoWin(){
        Boss boss = GameMaster.current_boss;
        Player player = Player.getCurrentPlayer();

        if (player.getHealth() < 1) {
            System.out.println("플레이어 패배");
        }
        if (boss.getHealth() < 1) {
            System.out.println("플레이어 패배");
        }
    }
   public static Player setPlayerTurn(){
        return Player.getCurrentPlayer() == Player.players[0] ? Player.players[1]: Player.players[0];
   }
}
