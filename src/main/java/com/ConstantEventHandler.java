package com;

import GUI.Dice_page;
import GUI.Fight_monster_page;

import static com.GameMaster.isTherePlayer;
import static com.Map.*;

import java.io.IOException;
import java.util.ArrayList;


import java.lang.Math;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ?Ή?  μ‘°κ±΄?? λ°λ? ?Ό?΄??Ό?? ?΄λ²€νΈ?€? ? λ¦¬ν ?΄??€
 * @author Chanho Park
 */
public class ConstantEventHandler
{
    /** shop() ?΄λΆ??? ?°?Ό λ³??λ‘?, ??΄? arraylist ?΄?€. */
    static ArrayList<ItemType> itemlist=new ArrayList<ItemType>();

    /**
     * shop()λ₯? ?¬?©?  ? κ΅¬λ§€ ? ??¬ ??΄? λͺ©λ‘? μ‘΄μ¬?¬λΆ?λ‘?  ?λ©΄μ μΆλ ₯?  ??΄? λͺ©λ‘? ? ???° ?¬?©??€.
     */
    static boolean shop_maintain_switch=false;

    /** @Deprecated ?λ§? ??°?΄?κΉ? μ§???Ό ? ?―?*/
    public static int fight_remain=0;

    /**
     * ??€ ?΄λ²€νΈλ₯? λ°μ??€? λ©μ?
     * @param player
     * ??€ ?΄λ²€νΈλ₯? μ§ν?  ?? ?΄?΄
     */
    static void generateRandomEvent(Player player)
    {
        int event_num=(int)Math.floor(Math.random()*21);
        RandomEventHandler.RandomEventIndicator(player, event_num);
    }

    /**
     * λ§΅μ ?΄λ¦???¬ ?? ?΄?΄κ°? ?΄??? €κ³? ?  ? ?΄???€? λ©μ?
     * @param player
     * ?΄?Ή ?? ?΄?΄
     * @param tile
     * λͺ©μ μ§?
     * @throws IOException
     */
    static public void move(Player player, TileType tile) throws IOException {
        boolean valid = pathValid(player, tile);

        if(valid)
        {
            player.setPos(tile);
            CheckEventHere(player, tile);
        }
    }

    /**
     * ?΄λ²€νΈλ‘? ?Έ?΄ ?? ?΄?΄κ°? ?΄??΄?Ό ?  ? ?΄???€? λ©μ?
     * <br>?΄ ?΄λ²€νΈλ‘? ?Έ?΄ ?΄λ²€νΈκ°? λ°μ?΄?Ό?? κ³³μΌλ‘? κ°? κ²½μ°?? ?΄λ²€νΈκ°? λ°μ?μ§? ???€.
     * @param player
     * ?΄?Ή ?? ?΄?΄
     * @param tile
     * λͺ©μ μ§?
     * @throws IOException
     */
    static void movebyTeleport(Player player, TileType tile) throws IOException {
        player.setPos(tile);
    }
    /**
     * ?? ?΄?΄κ°? ???μ§μΈ ?΄? ?ΈμΆ?, ???μ§μΌ ?? ?΄?΄??? λͺ©μ μ§?λ₯? λ°μ ?΄λ²€νΈ ?¬λΆ?λ₯? ??Έ?? λ©μ?
     * @param player
     *        ?΄?Ή ?? ?΄?΄
     * @param tile
     *        λͺ©μ μ§?
     */
    static public void CheckEventHere(Player player, TileType tile) throws IOException {
        if(Map.getPortalAt(tile))
        {
            fight_remain=2;
            generateFight(MonsterType.values()[(int) Math.floor(Math.random() * 5)]);

            if(player.getHealth() > 0)
            {
                GameMaster.token++;
                MainGamePageController.update_token(GameMaster.token);
                Map.tiles[tile.ordinal()].setSummoned_portal(false);
                MainGamePageController.show_portals();
            }
        }
        else if(Map.getMonsterAt(tile) != null)
        {
            fight_remain=1;
            ConstantEventHandler.generateFight(Map.getMonsterAt(tile).getMonster_type());
        }
        else if(tile == TileType.HOSPITAL)
        {
            hospital(player);
        }
        else if(tile == TileType.MENTAL_HOSPITAL)
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

    /**
     * ?? ?΄?΄?κ²? ??΄?? μΆκ???κ³? κ·Έμ ???? ?₯? ₯ μΆκ??μΉλ?? ? ?©??€? λ©μ?
     * @param player
     * ?΄?Ή ?? ?΄?΄
     * @param item
     * ?»κ²? ?? ??΄?
     */
    static void addItem(Player player, ItemType item)
    {
        ArrayList<ItemType> tempitems = player.getItems();
        tempitems.add(item);
        player.setItems(tempitems);
        player.setHealth(player.getHealth()+item.getHealth());
        player.setMental(player.getMental()+item.getMental());
        player.setPower(player.getPower()+item.getPower());
        player.setDexterity(player.getDexterity()+item.getDex());
        player.setIntelligence(player.getIntelligence()+item.getInt());
    }

    /**
     * ?? ?΄?΄?κ²? λ¬΄μ? ??΄?? μΆκ????€κ³? ?₯? ₯ μΆκ??μΉλ?? ? ?©?? λ©μ?
     * @param player
     * ?΄?Ή ?? ?΄?΄
     */
    static void addRandomItem(Player player)
    {
        int tempRand=(int)Math.floor(Math.random()*15);
        ArrayList<ItemType> tempitems=player.getItems();
        tempitems.add(ItemType.values()[tempRand]);
        player.setItems(tempitems);
        player.setHealth(player.getHealth()+ItemType.values()[tempRand].getHealth());
        player.setMental(player.getMental()+ItemType.values()[tempRand].getMental());
        player.setPower(player.getPower()+ItemType.values()[tempRand].getPower());
        player.setDexterity(player.getDexterity()+ItemType.values()[tempRand].getDex());
        player.setIntelligence(player.getIntelligence()+ItemType.values()[tempRand].getInt());
    }


    /**
     * λ³μ ?΄λ²€νΈ? κ΄?? λ©μ?
     * @param player
     * λ³μ? ?μ°©ν ?? ?΄?΄
     */
    static void hospital(Player player)
    {
        String message="λ³μ? ?μ°©ν?΅??€. μΉλ£λ°μΌ?κ² μ΅?κΉ??";
        DialogPanelController.show_dialog(message);
        DialogPanelController.show_dialog_answer1(new Answer("1. μΉλ£??€","hospital1"));
        DialogPanelController.show_dialog_answer2(new Answer("2. ? ??€","hospital2"));
    }
    /**
     * ? ? λ³μ ?΄λ²€νΈ? κ΄?? λ©μ?
     * @param player
     * ? ? λ³μ? ?μ°©ν ?? ?΄?΄
     */
    static void mospital(Player player)
    {
        String message="? ? λ³μ? ?μ°©ν?΅??€. μΉλ£λ°μΌ?κ² μ΅?κΉ??";
        DialogPanelController.show_dialog(message);
        DialogPanelController.show_dialog_answer1(new Answer("1. μΉλ£??€","mospital1"));
        DialogPanelController.show_dialog_answer2(new Answer("2. ? ??€","mospital2"));
    }

    /**
     * ?Όλ°? λͺ¬μ€?° ? ?¬ μ°½μΌλ‘? ??΄κ°?κ²? ?? λ©μ?
     * @param monster
     * ? ?¬?  λͺ¬μ€?°
     * @throws IOException
     */
    public static void generateFight(MonsterType monster) throws IOException {
        Fight_monster_page fightwithmonster = new Fight_monster_page(new Monster(monster));
    }

    /**
     * μ£Όμ¬? μ°½μ μΆλ ₯?? λ©μ?
     * @return Dice.getSavedDice_num()
     * 1~6 μ€μ λ¬΄μ?λ‘? ? ?? int?? κ°?
     */
    public static int  Dice(){
        Dice_page Dice = new Dice_page();
        Dice.setVisible(true);

        java.util.Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Dice.dispose();
            }
        },1*1*1000);
        return Dice.getSavedDice_num();
    }

    /**
     * ?΄?Ή ??΄??΄ ?? ?΄?΄κ°? ?μ§?? κΈμ‘?Όλ‘? κ΅¬λ§€?  ? ??μ§? ??Έ?? λ©μ?
     * @param player
     * ?? ?΄?΄
     * @param item
     * κ΅¬λ§€?? €κ³? ?? ??΄?
     * @return κ΅¬λ§€ κ°??₯ ?¬λΆ?
     */
    static boolean isAffordable(Player player, ItemType item)
    {
        if(player.getMoney()<item.getPrice())
            return false;
        else
            return true;
    }

    /**
     * ??΄? κ΅¬λ§€ ? κ΅¬λ§€ ? ??‘? ?? ?΄?΄?κ²? ?κ²¨μ£Ό? λ©μ?
     * @param player
     * ?? ?΄?΄
     * @param item
     * κ΅¬λ§€? ??΄?
     * @return κ΅¬λ§€ ? ??‘
     */
    static int getChange(Player player, ItemType item)
    {
        return player.getMoney()-item.getPrice();
    }

    /**
     * ?? ? ?μ°©ν  ?λ§λ€ ??΄? λ¦¬μ€?Έλ₯? κ°±μ ?? λ©μ?
     * @return λ¬΄μ?λ‘? ? ? ? ??΄? λ¦¬μ€?Έ
     */
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

    /**
     * λͺ¬μ€?°λ₯? ??±?? λ©μ?
     * <br>λͺ¬μ€?°? λ³μ, ?? , ? ? λ³μ, ?? ?΄?΄κ°? ?μΉνκ³? ?? κ³?, ?¬?Έ?΄? λͺ¬μ€?°κ°? ?΄λ―? μ‘΄μ¬?? κ³³μ? ??±?  ? ??€.
     * @param monster
     * ??±?  λͺ¬μ€?°
     * @param tile
     * λͺ¬μ€?°κ°? ??±?  ?₯?
     */
    static void CreateMonster(MonsterType monster, TileType tile)
    {
        if(isTherePlayer(Map.tiles[tile.ordinal()])
                &&Map.tiles[tile.ordinal()].getSummoned_monster() == null
                &&Map.tiles[tile.ordinal()].isSummoned_portal()==false
                &&Map.tiles[tile.ordinal()].getTile_type()!=TileType.MENTAL_HOSPITAL
                &&Map.tiles[tile.ordinal()].getTile_type()!=TileType.HOSPITAL
                &&Map.tiles[tile.ordinal()].getTile_type()!=TileType.STORE)
        {
            Monster tempMon=new Monster(monster);
            Map.tiles[tile.ordinal()].setSummoned_monster(tempMon);
        }
    }

    /**
     * ??  ?΄λ²€νΈλ₯? μ§ν??€? λ©μ?
     */
    static void shop()
    {
        String message="?? ? ?μ°©ν?΅??€. κ΅¬λ§€??€κ²? ??Ό? κ°???";
        DialogPanelController.show_dialog(message);

        if(!shop_maintain_switch)
        {
            itemlist=getRandomItemList();
        }

        StringBuilder itemInfo1 = new StringBuilder();
        if(itemlist.get(0)!=null){
            itemInfo1.append(itemlist.get(0).getName());
            itemInfo1.append("  ");
            itemInfo1.append("κ°?κ²?:");
            itemInfo1.append(itemlist.get(0).getPrice());}


        StringBuilder itemInfo2 = new StringBuilder();
        if(itemlist.get(1)!=null){
        itemInfo2.append(itemlist.get(1).getName());
        itemInfo2.append("  ");
        itemInfo2.append("κ°?κ²?:");
        itemInfo2.append(itemlist.get(1).getPrice());}


        StringBuilder itemInfo3 = new StringBuilder();
        if(itemlist.get(2)!=null){
        itemInfo3.append(itemlist.get(2).getName());
        itemInfo3.append("  ");
        itemInfo3.append("κ°?κ²?:");
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

        if(itemlist.get(0)==null&&itemlist.get(1)==null&&itemlist.get(2)==null)
        {
            DialogPanelController.Clear();
            String message3="?€?? λ¬Όκ±΄?€??? λͺ¨λ ?? Έ?΅??€. ?€? λ²μ λ°©λ¬Έ?΄μ£ΌμκΈ?.";
            DialogPanelController.show_dialog(message3);
            Answer answer1 = new Answer("1. ??  ?κ°?κΈ?", "continue");
            DialogPanelController.show_dialog_answer1(answer1);
        }
    }
}