package com;

import GUI.Fight_boss_page;
import GUI.Game_resultPage;
import java.io.IOException;

/**
 * ?‚¬?‹¤ ì»¨íŠ¸ë¡¤ëŸ¬?¼ ?•˜ê¸°ì—” ?• ë§¤í•˜?‹¤.
 * ë³´ìŠ¤??? ? „?ˆ¬?•  ?•Œ, ?“°?¼ ?°?´?„° ì²˜ë¦¬?— ê´??•œ ë©”ì†Œ?“œ?“¤ë¡? êµ¬ì„±?˜?–´ ?ˆ?‹¤.
 * ?”Œ? ˆ?´?–´ ê³µê²© ë°? ?—…?°?´?Š¸, ë³´ìŠ¤ ê³µê²© ë°? ?—…?°?´?Š¸, ?Š¹?Œ¨ ê²°ì • ë©”ì†Œ?“œ?“¤?´ ?ˆ?‹¤.
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
     * ë³´ìŠ¤ê°? ?”Œ? ˆ?´?–´ë¥? ê³µê²©?•  ?•Œ, ë³´ìŠ¤ ê°ì²´?˜ ?†?„±ê°’ê³¼ ì£¼ì‚¬?œ„ ê°’ì„ ?´?š©?•´ ?”Œ? ˆ?´?–´?˜ ì²´ë ¥?„ ?—…?°?´?Š¸ ?•˜?Š” ë©”ì†Œ?“œ
     * ì£½ì?? ?”Œ? ˆ?´?–´?Š” ?•Œë¦¬ì?? ?•Š?Š”?‹¤.
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
     * ?”Œ? ˆ?´?–´ê°? ëª¬ìŠ¤?„°ë¥? ê³µê²©?•  ?•Œ, ?”Œ? ˆ?´?–´?˜ ?†?„±ê³?, ì£¼ì‚¬?œ„ ê°’ì„ ?´?š©?•´ ëª¬ìŠ¤?„°?˜ ì²´ë ¥?„ ?—…?°?´?Š¸?•˜?Š” ë©”ì†Œ?“œ.
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
     * ?”Œ? ˆ?´?–´?˜ ?Š¹?Œ¨?— ?”°?¼, ê´?? ¨ ì°½ì„ ?„?›Œì£¼ëŠ” ë©”ì†Œ?“œ
     */
    public static void checkWhoWin() {
        Boss boss = GameMaster.current_boss;
        Game_resultPage result;

        if (fight_boss_page.boss_result = true) {
            if (Player.getPlayer(0).getHealth() < 1 && Player.getPlayer(1).getHealth() < 1) {
                System.out.println("?”Œ? ˆ?´?–´ ?Œ¨ë°?");
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
}
