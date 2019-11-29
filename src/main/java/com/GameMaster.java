package com;

import GUI.DialogPanel;
import GUI.Start_page;
import GUI.View;

import java.util.ArrayList;
import java.util.Arrays;

import static com.Player.*;

/**
 * 게임마스터 객체 모델로, 게임의 전체적인 데이터를 가지고 게임 진행의 방향을 결정할 수 있다.
 *
 * @author Se-Ok Jeon
 * @version 1.0
 */
public class GameMaster {

    static private final int GAME_WIN = 0;
    static private final int GAME_LOST = 1;
    static private final int GAME_KEEPGOING = 2;
    static private final int PLAYER_HEALTH_DEATH = 3;
    static private final int PLAYER_MENTAL_DEATH = 4;
    static private final int PLAYER_BOSS_DEATH = 5;

    public static int token = 0;
    public static int death_count=3;
    public static int turn = 1;
    public static Boss current_boss;

    private ConstantEventHandler constant_event_handler;

    public static void main(String[] args) {
        Start_page.Start_pageView();
    }

    private static void initiatePlayers() {
        for(int i = 0; i<2; i++){
            players[i] = Player
                    .builder()
                    .pos(TileType.A)
                    .money(100)
                    .items(null)
                    .characteristics("test")
                    .items(new ArrayList<ItemType>(Arrays.asList(ItemType.PROBLEM_OF_TIME, ItemType.AMULET_OF_HOUND)))
                    .build();
        }
    }
    public static void initiateGame(){
        token = 0;
        turn = 0;
        initiatePlayers();
        initMap();
        initMonsters();
    }
    private static void initItem(){
//        Player.items
    }
    private static void initMap(){

        Map.tiles = new Tile[13];
        for(int i = 0;i<13;i++){
            Map.tiles[i] = Tile
                    .builder()
                    .summoned_monster(null)
                    .summoned_portal(false)
                    .name(TileType.values()[i])
                    .build();
        }

    }
    private static void initMonsters(){}
    public static void setBoss(Boss selected_boss){
        current_boss = selected_boss;
    }
    public static boolean hasItem(ItemType item) {
        return getCurrentPlayer().getItems().indexOf(item) == -1 ? true:false;
    }
    public static boolean isEnergyLeft(Player player){
        return getCurrentPlayer().getEnergy() == 0 ? true:false;
    }
    public static void setInitializePlayerStats(int[] combined_stats){
        Player player = getCurrentPlayer();
        player.setPower(combined_stats[0]);
        player.setDexterity(combined_stats[1]);
        player.setIntelligence(combined_stats[2]);
        player.setMental(player.getMental()+combined_stats[3]);
        // 체력, 정신력은 1 + SetStatus_page에서 추가한 포인트로 세팅한다.
        player.setHealth(player.getHealth() + combined_stats[4]);

        if(player.getHealth() > 3) // player의 체력이 3 이상이면 여러번 움직일 수 있다.
            player.setEnergy(player.getHealth() / 3);
        else if(player.getHealth() > 0) // player가 죽지 않았으면 1번 이상 움직일 수 있다.
            player.setEnergy(1); // 최소 값
        else // 플레이어가 죽었으면 움직일 수 없다.
            player.setEnergy(0);
    }
    public static void death(Player player)
    {
        for(int i=0;i<death_count;i++)
        {
           if(DialogPanelController.Dice()>5)
           {
               revive(player);
               death_count--;
               break;
           }
        }
        if(player.getHealth()<0||player.getMental()<0)
            player.setStatus(2);
    }
    private static void revive(Player player)
    {
        if(player.getMental()<0)
        {
            player.setMental(1);
            player.setPos(TileType.MENTAL_HOSTPITAL);
        }
        if(player.getHealth()<0)
        {
            player.setHealth(1);
            player.setPos(TileType.HOSPITAL);
        }
    }
    public static void turnEnd()
    {
        if(idx_of_cur_player == 1) // 2번째 플레이어의 턴 종료인가?
        {
            if(getCurrentPlayer().getHealth()<0||getCurrentPlayer().getMental()<0)
                death(getCurrentPlayer());

            if(check_num_of_token_for_win())
            {
                //승리 엔딩 출력
            }
            if(check_player_status_for_lost())
            {
                //패배 엔딩 출력
            }
            if(check_num_of_monsters_portals_for_boss())
            {
                generateBossFight(current_boss);
            }

            if(turn % 3 == 0)
                setPortalAndMonsterRandomly();

            getCurrentPlayer().setEnergy(getCurrentPlayer().getHealth()/3);
            if(getCurrentPlayer().getEnergy() == 0 && getCurrentPlayer().getStatus() != 2)
                getCurrentPlayer().setEnergy(1);

            Player.toggleCurrentPlayer();
            turn++;
            // Update turn value to MainGame_page(view)
            MainGamePageController.maingame_page.getTab().getTurn_text().setText(Integer.toString(turn));
        }
        else
        {
            if(getCurrentPlayer().getHealth()<0||getCurrentPlayer().getMental()<0)
                death(getCurrentPlayer());

            if(check_num_of_token_for_win())
            {
                //승리 엔딩 출력
            }
            if(check_player_status_for_lost())
            {
                //패배 엔딩 출력
            }
            if(check_num_of_monsters_portals_for_boss())
            {
                generateBossFight(current_boss);
            }

            Player.toggleCurrentPlayer();
        }
        DialogPanelController.generateGeneralDialogues();
    }
    private static boolean check_num_of_token_for_win()
    {
        if(token==10)
        return true;
        else return false;
    }
    private static boolean check_player_status_for_lost()
    {
        if(players[0].getStatus()==2&&players[1].getStatus()==2)
        return true;
        else return false;
    }
    private static boolean check_num_of_monsters_portals_for_boss()
    {
        int tempNum=0;
        int tempNum2=0;

        for(int i=0;i<13;i++)
        {
            if (Map.tiles[i].getSummoned_monster()!=null)
                tempNum++;
        }
        for(int j=0;j<13;j++)
        {
            if(Map.tiles[j].isSummoned_portal())
                tempNum2++;
        }

        if(tempNum>6||tempNum2>4)
        return true;
        else return false;
    }
    public static void setPortalAndMonsterRandomly()
    {
        while(true)
        {
            int tempNum1=(int)Math.floor(Math.random()*13);
            int tempNum2=(int)Math.floor(Math.random()*5);
            MonsterType monster=MonsterType.values()[tempNum2];
            Monster tempMon=new Monster(monster.getName(), monster.getInitial_health(), monster.getInitial_requireVal(), monster.getInitial_damage(), monster.getInitial_damageType(),monster.getInitial_monster_result());
            if(Map.tiles[tempNum1].getSummoned_monster()==null&&Map.tiles[tempNum1].isSummoned_portal()==false)
            {
                Map.tiles[tempNum1].setSummoned_monster(tempMon);
                break;
            }
            else continue;
        }

        while(true)
        {
            int tempNum1=(int)Math.floor(Math.random()*13);
            if(Map.tiles[tempNum1].getSummoned_monster()==null&&Map.tiles[tempNum1].isSummoned_portal()==false)
            {
                Map.tiles[tempNum1].setSummoned_portal(true);
                break;
            }
            else continue;
        }
    }
    public static void generateBossFight(Boss boss){}

}
