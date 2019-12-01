package com;

import GUI.Dice_page;
import GUI.Fight_monster_page;

import static com.Map.*;
import java.util.ArrayList;


import java.lang.Math;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 특정 조건에서 반드시 일어나야하는 이벤트들을 정리한 클래스
 * @author Chanho Park
 */
public class ConstantEventHandler
{

    static ArrayList<ItemType> itemlist=new ArrayList<ItemType>();
    static boolean shop_maintain_switch=false;

    static void generateRandomEvent(Player player)
    {
        int event_num=(int)Math.floor(Math.random()*21);
        RandomEventHandler.RandomEventIndicator(player, event_num);
    }
    static public void move(Player player, TileType tile)
    {
        boolean valid = pathValid(player, tile);

        if(valid)
        {
            player.setPos(tile);
            CheckEventHere(player, tile);
        }
        else
        {
//            ShowDialog("이동할 수 없는 곳입니다");
        }
    }
    static void movebyTeleport(Player player, TileType tile){player.setPos(tile);}
    /**
     * 플레이어가 움직인 이후 호출, 움직일 플레이어와 목적지를 받아 이벤트 여부를 확인하는 메소드
     * @param player
     *        해당 플레이어
     * @param tile
     *        목적지
     */
    static public void CheckEventHere(Player player, TileType tile)
    {
        if(Map.getPortalAt(tile))
        {
            // 테스트 몬스터 전투
            generateFight(Map.getMonsterAt(tile).getMonster_type());
            // TODO : 두 싸움 사이에 딜레이가 들어가야 한다. 차례차례 싸워야 함 아니면 한번만 싸우도록 바꿔야 한다.
//            generateFight(player, MonsterType.Dagon);              //포털을 닫기 위해서는 2번의 전투 필요
            if(player.getHealth() > 0)
            {
                GameMaster.token++;
                MainGamePageController.update_token(GameMaster.token);
                Map.tiles[tile.ordinal()].setSummoned_portal(false);
            }
        }
        if(Map.getMonsterAt(tile) != null)
        {
            ConstantEventHandler.generateFight(Map.getMonsterAt(tile).getMonster_type());
            if(player.getHealth() > 0)
            {
                Map.tiles[tile.ordinal()].setSummoned_monster(null);
            }
        }

        if(tile == TileType.HOSPITAL)
        {
            hospital(player);
        }
        else if(tile == TileType.MENTAL_HOSTPITAL)
        {
            mospital(player);
        }
        else if(tile == TileType.STORE)
        {
            shop();
        }
        else
        {
            DialogPanelController.Clear();
            DialogPanelController.generateGeneralDialogues();
        }

    }
    static void addItem(Player player, ItemType item)
    {
        ArrayList<ItemType> tempitems = player.getItems();
        tempitems.add(item);
        player.setItems(tempitems);
    }


    static void deleteItem(Player player, ItemType item)
    {
        ArrayList<ItemType> tempitems=player.getItems();
        for(int i=0;i<tempitems.size();i++)
        {
            if(tempitems.get(i)==item)
            {
                tempitems.remove(i);
            }
        }
        player.setItems(tempitems);
    }


    static void addRandomItem(Player player)
    {
        int tempRand=(int)Math.floor(Math.random()*15);
        ArrayList<ItemType> tempitems=player.getItems();
        tempitems.add(ItemType.values()[tempRand]);
        player.setItems(tempitems);
    }


    static void hospital(Player player)
    {
        String message="병원에 도착했습니다. 치료받으시겠습니까?";
        DialogPanelController.show_dialog(message);
        DialogPanelController.show_dialog_answer1(ConstantEventAnswer.hospital1);
        DialogPanelController.show_dialog_answer2(ConstantEventAnswer.hospital2);
    }

    static void mospital(Player player)
    {
        String message="정신병원에 도착했습니다. 치료받으시겠습니까?";
        DialogPanelController.show_dialog(message);
        DialogPanelController.show_dialog_answer1(ConstantEventAnswer.mospital1);
        DialogPanelController.show_dialog_answer2(ConstantEventAnswer.mospital2);
    }

    static void generateFight(MonsterType monster){
        FightMonsterController fightwithmonster = new FightMonsterController(monster);
    }

    public static int  Dice(){
        Dice_page Dice = new Dice_page();
        Dice.setVisible(true);

        java.util.Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Dice.dispose();
            }
        },1*2*1000 , 1*2* 1000);
        return Dice.getSavedDice_num();
    }

    static boolean isAffordable(Player player, ItemType item)
    {
        if(player.getMoney()<item.getPrice())
            return false;
        else
            return true;
    }
    static int getChange(Player player, ItemType item)
    {
        return player.getMoney()-item.getPrice();
    }
    static void sellItem(Player player, ItemType item){}
    static ItemType getItem(ItemType item){return null;}

    static ArrayList<ItemType> getRandomItemList()
    {
        ArrayList<ItemType> tempitemlist = new ArrayList<ItemType>();
        int old_temp1=18;
        int old_temp2=18;
        while(true)
        {
            int tempRand=(int)Math.floor(Math.random()*15);

            if(tempRand!=old_temp1&&tempRand!=old_temp2)
                tempitemlist.add(ItemType.values()[tempRand]);

            old_temp1=tempRand;
            old_temp2=old_temp1;

            if(tempitemlist.size()==3)
                break;
        }
        return tempitemlist;
    }

    static void CreateMonster(MonsterType monster, TileType tile)
    {
        if(Map.tiles[tile.ordinal()].getSummoned_monster()==null&&Map.tiles[tile.ordinal()].isSummoned_portal()==false)
        {
            Monster tempMon=new Monster(monster, monster.getInitial_health(), monster.getInitial_requireVal(), monster.getInitial_damage(), monster.getInitial_damageType(),monster.getInitial_monster_result(),monster.getInintial_imgpath());
            Map.tiles[tile.ordinal()].setSummoned_monster(tempMon);
        }
    }

    /**
     * Answer 객체가 이벤트용인지 상점용인지 구별하는 메소드<br>
     * @param answer
     * <br>판별할 Answer
     * @return
     * <br>true=이벤트용
     * <br>false=상점용
     */
    static boolean AnswerChecker(Answer answer)
    {
        if(answer.getItem()==null)
            return true;
        else
            return false;
    }

    static void shop()
    {
        String message="상점에 도착했습니다. 구매하실게 있으신가요?";
        DialogPanelController.show_dialog(message);

        if(!shop_maintain_switch)
        {
            itemlist=getRandomItemList();
        }

        StringBuilder itemInfo1 = new StringBuilder();
        if(itemlist.get(0)!=null){
            itemInfo1.append(itemlist.get(0).getName());
            itemInfo1.append("  ");
            itemInfo1.append("가격:");
            itemInfo1.append(itemlist.get(0).getPrice());}


        StringBuilder itemInfo2 = new StringBuilder();
        if(itemlist.get(1)!=null){
        itemInfo2.append(itemlist.get(1).getName());
        itemInfo2.append("  ");
        itemInfo2.append("가격:");
        itemInfo2.append(itemlist.get(1).getPrice());}


        StringBuilder itemInfo3 = new StringBuilder();
        if(itemlist.get(2)!=null){
        itemInfo3.append(itemlist.get(2).getName());
        itemInfo3.append("  ");
        itemInfo3.append("가격:");
        itemInfo3.append(itemlist.get(2).getPrice());}

        shop_maintain_switch=false;

        Answer item1 = new Answer(itemlist.get(0), itemInfo1.toString(), "shop");
        Answer item2 = new Answer(itemlist.get(1), itemInfo2.toString(), "shop");
        Answer item3 = new Answer(itemlist.get(2), itemInfo3.toString(), "shop");
        if(itemlist.get(0)!=null)
        DialogPanelController.show_dialog_answer1(item1);
        if(itemlist.get(1)!=null)
        DialogPanelController.show_dialog_answer2(item2);
        if(itemlist.get(2)!=null)
        DialogPanelController.show_dialog_answer3(item3);
    }
}