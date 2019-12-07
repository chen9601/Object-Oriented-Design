package com;

import GUI.Fight_boss_page;
import GUI.Game_resultPage;
import java.io.IOException;

/**
 * ?��?�� 컨트롤러?�� ?��기엔 ?��매하?��.
 * 보스??? ?��?��?�� ?��, ?��?�� ?��?��?�� 처리?�� �??�� 메소?��?���? 구성?��?�� ?��?��.
 * ?��?��?��?�� 공격 �? ?��?��?��?��, 보스 공격 �? ?��?��?��?��, ?��?�� 결정 메소?��?��?�� ?��?��.
 *
 * @author Se-Ok Jeon
 */
public class Fight_boss_controller {
    public static GUI.Fight_boss_page fight_boss_page;

    public Fight_boss_controller() throws IOException {
        fight_boss_page = new Fight_boss_page();
        fight_boss_page.setVisible(true);
    }

    /**
     * 보스�? ?��?��?��?���? 공격?�� ?��, 보스 객체?�� ?��?��값과 주사?�� 값을 ?��?��?�� ?��?��?��?��?�� 체력?�� ?��?��?��?�� ?��?�� 메소?��
     * 죽�?? ?��?��?��?��?�� ?��리�?? ?��?��?��.
     */
    public static void attackedPlayerByBoss() throws IOException {
        int bonus_val=0;
        if(GameMaster.current_boss.getType()==BossType.CHUTHULU)
        {
            bonus_val=1;
        }
        Player.toggleCurrentPlayer();
        Player player = Player.getCurrentPlayer();
        if(player.getHealth() < 1){
            Player.toggleCurrentPlayer();
            player = Player.getCurrentPlayer();
        }
        int temp2 = ConstantEventHandler.Dice();
        Boss boss = GameMaster.current_boss;
        if (temp2 > boss.getRequireVal()) {
            player.setHealth(player.getHealth() - boss.getDamage()-bonus_val);
            if (player == Player.getPlayer(0)) {
                Fight_boss_page.player1_status_panel.getStatus_details()[StatusType.HEALTH.ordinal()].getAttribute_textpane().setText(Integer.toString(player.getHealth()));
            } else {
                Fight_boss_page.player2_status_panel.getStatus_details()[StatusType.HEALTH.ordinal()].getAttribute_textpane().setText(Integer.toString(player.getHealth()));
            }
        }
    }

    /**
     * ?��?��?��?���? 몬스?���? 공격?�� ?��, ?��?��?��?��?�� ?��?���?, 주사?�� 값을 ?��?��?�� 몬스?��?�� 체력?�� ?��?��?��?��?��?�� 메소?��.
     */
    public static void attackedBossByPlayer() throws IOException {

        int dice_value = ConstantEventHandler.Dice();
        Boss boss = GameMaster.current_boss;
        if (dice_value > boss.getRequireVal()) {

            boss.setHealth(boss.getHealth() - 1);

            Fight_boss_page.show_stars();

        }
    }

    /**
     * 게임의 결과를 측정한 후 승리 또는 패배 창을 띄운다.
     */
    public static void checkWhoWin() {
        Boss boss = GameMaster.current_boss;
        Game_resultPage result;


            if (Player.getPlayer(0).getHealth() < 1 && Player.getPlayer(1).getHealth() < 1) {
                fight_boss_page.dispose();
                result = new Game_resultPage("defeat");
                result.setVisible(true);
            } else if (boss.getHealth() < 1) {
                fight_boss_page.dispose();
                result = new Game_resultPage("win");
                result.setVisible(true);
            }
            MainGamePageController.maingame_page.dispose();

    }
}
