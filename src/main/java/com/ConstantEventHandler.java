package com;

import static com.Map.*;
import java.util.ArrayList;

import GUI.View;

import java.lang.Math;

/**
 * 특정 조건에서 반드시 일어나야하는 이벤트들을 정리한 클래스
 * @author Chanho Park
 */
public class ConstantEventHandler
{
    View view;
    ConstantEventAnswer cc;

    void generateRandomEvent(Player player)
    {
        int event_num=(int)Math.floor(Math.random()*20);
        RandomEventHandler.RandomEventIndicator(player, event_num);
    }
    public void move(Player player, TileType tile)
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
    void movebyTeleport(Player player, TileType tile){player.setPos(tile);}
    /**
     * 플레이어가 움직인 이후 호출, 움직일 플레이어와 목적지를 받아 이동가능 여부를 확인 후 이동시키는 메소드
     * @param player
     *        해당 플레이어
     * @param tile
     *        목적지
     */
    public void CheckEventHere(Player player, TileType tile)
    {
        if(Map.getPortalAt(tile))
        {
//            GenerateFight(player);
//            GenerateFight(player);                                  //포털을 닫기 위해서는 2번의 전투 필요
            if(player.getHealth() > 0)
            {
                GameMaster.token++;
                Map.tiles[tile.ordinal()].setSummoned_portal(false);
            }
        }
        if(Map.getMonsterAt(tile) != null)
        {
//            GenerateFight();
            if(player.getHealth() > 0)
            {
                Map.tiles[tile.ordinal()].setSummoned_monster(null);
            }
        }

        if(tile == TileType.HOSPITAL)
        {
            hospital(player);
        }

        if(tile == TileType.MENTAL_HOSTPITAL)
        {
            mospital(player);
        }

        if(tile == TileType.STORE)
        {
//            Shop();
        }

    }
    void addItem(Player player, ItemType item)
    {
        ArrayList<ItemType> tempitems = player.getItems();
        tempitems.add(item);
        player.setItems(tempitems);
    }


    void deleteItem(Player player, ItemType item)
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


    void addRandomItem(Player player)
    {
        int tempRand=(int)Math.floor(Math.random()*15);
        ArrayList<ItemType> tempitems=player.getItems();
        tempitems.add(ItemType.values()[tempRand]);
        player.setItems(tempitems);
    }


    void hospital(Player player)
    {
        String message="병원에 도착했습니다. 치료받으시겠습니까?";
        view.show_dialog(message);
        view.show_dialog_answer1(cc.hospital1);
        view.show_dialog_answer2(cc.hospital2);
    }

    void mospital(Player player)
    {
        String message="정신병원에 도착했습니다. 치료받으시겠습니까?";
        view.show_dialog(message);
        view.show_dialog_answer1(cc.mospital1);
        view.show_dialog_answer2(cc.mospital2);
    }
    
    void generateFight(Player player, MonsterType monster){}
    boolean isAffordable(Player player, ItemType item)
    {
        if(player.getMoney()<item.getPrice())
            return false;
        else
            return true;
    }
    int getChange(Player player, ItemType item)
    {
        return player.getMoney()-item.getPrice();
    }
    void sellItem(Player player, ItemType item){}
    ItemType getItem(ItemType item){return null;}
    ArrayList<ItemType> getRandomItemList()
    {
        ArrayList<ItemType> tempitemlist = null;
        for(int i=0;i<3;i++)
        {
            int tempRand=(int)Math.floor(Math.random()*15);
            tempitemlist.add(ItemType.values()[tempRand]);
        }
        return tempitemlist;
    }

    void CreateMonster(MonsterType monster, TileType tile)
    {
        Monster tempMon=new Monster(monster.getName(), monster.getInitial_health(), monster.getInitial_requireVal(), monster.getInitial_damage(), monster.getInitial_damageType(),monster.getInitial_monster_result());
        Map.tiles[tile.ordinal()].setSummoned_monster(tempMon);
    }

    /**
     * Answer 객체가 이벤트용인지 상점용인지 구별하는 메소드<br>
     * @param answer
     * <br>판별할 Answer
     * @return
     * <br>true=이벤트용
     * <br>false=상점용
     */
    boolean AnswerChecker(Answer answer)
    {
        if(answer.getItem()==null)
            return true;
        else
            return false;
    }

    void shop()
    {
        String message="상점에 도착했습니다. 구매하실게 있으신가요";
        view.show_dialog(message);
        ArrayList<ItemType> itemlist=getRandomItemList();
        Answer item1=new Answer(itemlist.get(0));
        Answer item2=new Answer(itemlist.get(1));
        Answer item3=new Answer(itemlist.get(2));
        view.show_dialog_answer1(item1);
        view.show_dialog_answer2(item2);
        view.show_dialog_answer3(item3);
    }
}