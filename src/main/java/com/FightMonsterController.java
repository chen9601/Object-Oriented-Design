package com;

import GUI.DialogPanel;
import GUI.Fight_monster_page;
import GUI.music.Mainmusic_thread;
import lombok.Data;

import java.util.TimerTask;

@Data
public class FightMonsterController
{
    public static Fight_monster_page fight_monster_page;
//    public static Fight_monster_page.FightDialogPanelController fight_dialog_panel_controller;
    public static Fight_monster_page.MonsterPanel monsterPanel;
    public static Fight_monster_page.PlayerPanel player_panel;
    public static java.util.Timer timer = new java.util.Timer();
    public static Monster monster;


    public FightMonsterController(MonsterType monster){
        this.monster = new Monster(monster);
        fight_monster_page = new Fight_monster_page(this.monster);
        monsterPanel = fight_monster_page.getMonsterPanel();
        player_panel = fight_monster_page.getPlayer_panel();
        fight_monster_page.setVisible(true);
    }

    public static void attackMonster(){
        int dice_value = ConstantEventHandler.Dice();
        if(dice_value >= monster.getRequireVal()){
                FightDialogPanelController.show_dialog(
                        "플레이어가 몬스터에게 "
                                + Integer.toString(dice_value - monster.getRequireVal())
                                + "의 피해를 입혔습니다."
                );
            }
    }

//    public static void normalFight(Player player, Monster monster){
//        //전투 창 불러오기
//        while(true)
//        {
//            int temp=ConstantEventHandler.Dice();
//            if(temp>=monster.getRequireVal())
//            {
//                appendTextWithNewLine(Integer.toString(temp -monster.getRequireVal()));
//                monster.setHealth(monster.getHealth()-1);
//            }
//            else
//            {
//                appendTextWithNewLine("데미지를 입히지 못했습니다.");
//            }
//            delay(10);
//
////            try{
////                TimeUnit.SECONDS.sleep(10);
////            }
////            catch(InterruptedException e){
////                e.getMessage()
////            }
//
//            if(monster.getHealth()<1)
//            {
//                appendTextWithNewLine("몬스터와의 전투에서 승리하였습니다.");
//                player.setMoney(player.getMoney()+monster.getMonster_result());
//                Map.tiles[player.getPos().ordinal()].setSummoned_monster(null);
//                break;
//            }
//
//            int temp2=ConstantEventHandler.Dice();
//            if(temp2>=monster.getRequireVal())
//            {
//                appendTextWithNewLine(Integer.toString(temp2 - monster.getRequireVal()));
//                if(monster.getDamageType()==1)
//                    player.setHealth(player.getHealth()-monster.getDamage());
//                else if(monster.getDamageType()==2)
//                    player.setMental(player.getMental()-monster.getDamage());
//            }
//            else
//            {
//                appendTextWithNewLine("데미지를 입히지 못했습니다.");
//            }
//
//            delay(10);
//
//            if(player.getHealth()<1)
//            {
//                appendTextWithNewLine("몬스터와의 전투에서 패배하였습니다.");
//                player.setStatus(2);
//                break;
//            }
//        }
//        delay(10);
//    }

//    private static void delay(int duration) {
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                ConstantEventHandler.Dice();
//            }
//        },duration*1000 , duration*1000);
//    }


//    public static void appendTextWithNewLine(String text){
//        Fight_monster_page.FightDialogPanelController..setText(dialog.getText() + "\n" + text);
//    }

    public static void bossFight()
    {

    }
}
