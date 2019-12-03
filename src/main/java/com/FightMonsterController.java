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
    public static FightDialogPanelController fight_dialog_panel_controller;
    public static Fight_monster_page.MonsterPanel monsterPanel;
    public static Fight_monster_page.PlayerPanel player_panel;
    public static Monster monster;


    public FightMonsterController(MonsterType monster){
        this.monster = new Monster(monster);
        fight_monster_page = new Fight_monster_page(this.monster);
        monsterPanel = fight_monster_page.getMonsterPanel();
        player_panel = fight_monster_page.getPlayer_panel();
        fight_monster_page.setVisible(true);
    }


}
