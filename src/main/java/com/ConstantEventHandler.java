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
 * ?Š¹? • ì¡°ê±´?—?„œ ë°˜ë“œ?‹œ ?¼?–´?‚˜?•¼?•˜?Š” ?´ë²¤íŠ¸?“¤?„ ? •ë¦¬í•œ ?´?˜?Š¤
 * @author Chanho Park
 */
public class ConstantEventHandler
{
    /** shop() ?‚´ë¶??—?„œ ?“°?¼ ë³??ˆ˜ë¡?, ?•„?´?…œ arraylist ?´?‹¤. */
    static ArrayList<ItemType> itemlist=new ArrayList<ItemType>();

    /**
     * shop()ë¥? ?‚¬?š©?•  ?•Œ êµ¬ë§¤ ?›„ ?”?—¬ ?•„?´?…œ ëª©ë¡?˜ ì¡´ì¬?—¬ë¶?ë¡?  ?™”ë©´ì— ì¶œë ¥?•  ?•„?´?…œ ëª©ë¡?„ ? •?•˜?Š”?° ?‚¬?š©?œ?‹¤.
     */
    static boolean shop_maintain_switch=false;

    /** @Deprecated ?•„ë§? ?•ˆ?“°?´?‹ˆê¹? ì§??›Œ?•¼ ?• ?“¯?*/
    public static int fight_remain=0;

    /**
     * ?œ?¤ ?´ë²¤íŠ¸ë¥? ë°œìƒ?‹œ?‚¤?Š” ë©”ì†Œ?“œ
     * @param player
     * ?œ?¤ ?´ë²¤íŠ¸ë¥? ì§„í–‰?•  ?”Œ? ˆ?´?–´
     */
    static void generateRandomEvent(Player player)
    {
        int event_num=(int)Math.floor(Math.random()*21);
        RandomEventHandler.RandomEventIndicator(player, event_num);
    }

    /**
     * ë§µì„ ?´ë¦??•˜?—¬ ?”Œ? ˆ?´?–´ê°? ?´?™?•˜? ¤ê³? ?•  ?•Œ ?´?™?‹œ?‚¤?Š” ë©”ì†Œ?“œ
     * @param player
     * ?•´?‹¹ ?”Œ? ˆ?´?–´
     * @param tile
     * ëª©ì ì§?
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
     * ?´ë²¤íŠ¸ë¡? ?¸?•´ ?”Œ? ˆ?´?–´ê°? ?´?™?•´?•¼ ?•  ?•Œ ?´?™?‹œ?‚¤?Š” ë©”ì†Œ?“œ
     * <br>?´ ?´ë²¤íŠ¸ë¡? ?¸?•´ ?´ë²¤íŠ¸ê°? ë°œìƒ?•´?•¼?•˜?Š” ê³³ìœ¼ë¡? ê°? ê²½ìš°?—?Š” ?´ë²¤íŠ¸ê°? ë°œìƒ?•˜ì§? ?•Š?Š”?‹¤.
     * @param player
     * ?•´?‹¹ ?”Œ? ˆ?´?–´
     * @param tile
     * ëª©ì ì§?
     * @throws IOException
     */
    static void movebyTeleport(Player player, TileType tile) throws IOException {
        player.setPos(tile);
    }
    /**
     * ?”Œ? ˆ?´?–´ê°? ???ì§ì¸ ?´?›„ ?˜¸ì¶?, ???ì§ì¼ ?”Œ? ˆ?´?–´??? ëª©ì ì§?ë¥? ë°›ì•„ ?´ë²¤íŠ¸ ?—¬ë¶?ë¥? ?™•?¸?•˜?Š” ë©”ì†Œ?“œ
     * @param player
     *        ?•´?‹¹ ?”Œ? ˆ?´?–´
     * @param tile
     *        ëª©ì ì§?
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
     * ?”Œ? ˆ?´?–´?—ê²? ?•„?´?…œ?„ ì¶”ê???•˜ê³? ê·¸ì— ????•œ ?Š¥? ¥ ì¶”ê??ì¹˜ë?? ? ?š©?‹œ?‚¤?Š” ë©”ì†Œ?“œ
     * @param player
     * ?•´?‹¹ ?”Œ? ˆ?´?–´
     * @param item
     * ?–»ê²? ?˜?Š” ?•„?´?…œ
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
     * ?”Œ? ˆ?´?–´?—ê²? ë¬´ì‘?œ„ ?•„?´?…œ?„ ì¶”ê???‹œ?‚¤ê³? ?Š¥? ¥ ì¶”ê??ì¹˜ë?? ? ?š©?•˜?Š” ë©”ì†Œ?“œ
     * @param player
     * ?•´?‹¹ ?”Œ? ˆ?´?–´
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
     * ë³‘ì› ?´ë²¤íŠ¸?— ê´??•œ ë©”ì†Œ?“œ
     * @param player
     * ë³‘ì›?— ?„ì°©í•œ ?”Œ? ˆ?´?–´
     */
    static void hospital(Player player)
    {
        String message="ë³‘ì›?— ?„ì°©í–ˆ?Šµ?‹ˆ?‹¤. ì¹˜ë£Œë°›ìœ¼?‹œê² ìŠµ?‹ˆê¹??";
        DialogPanelController.show_dialog(message);
        DialogPanelController.show_dialog_answer1(new Answer("1. ì¹˜ë£Œ?•œ?‹¤","hospital1"));
        DialogPanelController.show_dialog_answer2(new Answer("2. ?– ?‚œ?‹¤","hospital2"));
    }
    /**
     * ? •?‹ ë³‘ì› ?´ë²¤íŠ¸?— ê´??•œ ë©”ì†Œ?“œ
     * @param player
     * ? •?‹ ë³‘ì›?— ?„ì°©í•œ ?”Œ? ˆ?´?–´
     */
    static void mospital(Player player)
    {
        String message="? •?‹ ë³‘ì›?— ?„ì°©í–ˆ?Šµ?‹ˆ?‹¤. ì¹˜ë£Œë°›ìœ¼?‹œê² ìŠµ?‹ˆê¹??";
        DialogPanelController.show_dialog(message);
        DialogPanelController.show_dialog_answer1(new Answer("1. ì¹˜ë£Œ?•œ?‹¤","mospital1"));
        DialogPanelController.show_dialog_answer2(new Answer("2. ?– ?‚œ?‹¤","mospital2"));
    }

    /**
     * ?¼ë°? ëª¬ìŠ¤?„° ? „?ˆ¬ ì°½ìœ¼ë¡? ?„˜?–´ê°?ê²? ?•˜?Š” ë©”ì†Œ?“œ
     * @param monster
     * ? „?ˆ¬?•  ëª¬ìŠ¤?„°
     * @throws IOException
     */
    public static void generateFight(MonsterType monster) throws IOException {
        Fight_monster_page fightwithmonster = new Fight_monster_page(new Monster(monster));
    }

    /**
     * ì£¼ì‚¬?œ„ ì°½ì„ ì¶œë ¥?•˜?Š” ë©”ì†Œ?“œ
     * @return Dice.getSavedDice_num()
     * 1~6 ì¤‘ì— ë¬´ì‘?œ„ë¡? ?„ ?ƒ?œ int?˜•?˜ ê°?
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
     * ?•´?‹¹ ?•„?´?…œ?´ ?”Œ? ˆ?´?–´ê°? ?†Œì§??•œ ê¸ˆì•¡?œ¼ë¡? êµ¬ë§¤?•  ?ˆ˜ ?ˆ?Š”ì§? ?™•?¸?•˜?Š” ë©”ì†Œ?“œ
     * @param player
     * ?”Œ? ˆ?´?–´
     * @param item
     * êµ¬ë§¤?•˜? ¤ê³? ?•˜?Š” ?•„?´?…œ
     * @return êµ¬ë§¤ ê°??Š¥ ?—¬ë¶?
     */
    static boolean isAffordable(Player player, ItemType item)
    {
        if(player.getMoney()<item.getPrice())
            return false;
        else
            return true;
    }

    /**
     * ?•„?´?…œ êµ¬ë§¤ ?‹œ êµ¬ë§¤ ?›„ ?”?•¡?„ ?”Œ? ˆ?´?–´?—ê²? ?„˜ê²¨ì£¼?Š” ë©”ì†Œ?“œ
     * @param player
     * ?”Œ? ˆ?´?–´
     * @param item
     * êµ¬ë§¤?•œ ?•„?´?…œ
     * @return êµ¬ë§¤ ?›„ ?”?•¡
     */
    static int getChange(Player player, ItemType item)
    {
        return player.getMoney()-item.getPrice();
    }

    /**
     * ?ƒ? ?— ?„ì°©í•  ?•Œë§ˆë‹¤ ?•„?´?…œ ë¦¬ìŠ¤?Š¸ë¥? ê°±ì‹ ?•˜?Š” ë©”ì†Œ?“œ
     * @return ë¬´ì‘?œ„ë¡? ?„ ? •?œ ?•„?´?…œ ë¦¬ìŠ¤?Š¸
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
     * ëª¬ìŠ¤?„°ë¥? ?ƒ?„±?•˜?Š” ë©”ì†Œ?“œ
     * <br>ëª¬ìŠ¤?„°?Š” ë³‘ì›, ?ƒ? , ? •?‹ ë³‘ì›, ?”Œ? ˆ?´?–´ê°? ?œ„ì¹˜í•˜ê³? ?ˆ?Š” ê³?, ?¬?„¸?´?‚˜ ëª¬ìŠ¤?„°ê°? ?´ë¯? ì¡´ì¬?•˜?Š” ê³³ì—?Š” ?ƒ?„±?  ?ˆ˜ ?—†?‹¤.
     * @param monster
     * ?ƒ?„±?  ëª¬ìŠ¤?„°
     * @param tile
     * ëª¬ìŠ¤?„°ê°? ?ƒ?„±?  ?¥?†Œ
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
     * ?ƒ?  ?´ë²¤íŠ¸ë¥? ì§„í–‰?‹œ?‚¤?Š” ë©”ì†Œ?“œ
     */
    static void shop()
    {
        String message="?ƒ? ?— ?„ì°©í–ˆ?Šµ?‹ˆ?‹¤. êµ¬ë§¤?•˜?‹¤ê²? ?ˆ?œ¼?‹ ê°??š”?";
        DialogPanelController.show_dialog(message);

        if(!shop_maintain_switch)
        {
            itemlist=getRandomItemList();
        }

        StringBuilder itemInfo1 = new StringBuilder();
        if(itemlist.get(0)!=null){
            itemInfo1.append(itemlist.get(0).getName());
            itemInfo1.append("  ");
            itemInfo1.append("ê°?ê²?:");
            itemInfo1.append(itemlist.get(0).getPrice());}


        StringBuilder itemInfo2 = new StringBuilder();
        if(itemlist.get(1)!=null){
        itemInfo2.append(itemlist.get(1).getName());
        itemInfo2.append("  ");
        itemInfo2.append("ê°?ê²?:");
        itemInfo2.append(itemlist.get(1).getPrice());}


        StringBuilder itemInfo3 = new StringBuilder();
        if(itemlist.get(2)!=null){
        itemInfo3.append(itemlist.get(2).getName());
        itemInfo3.append("  ");
        itemInfo3.append("ê°?ê²?:");
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
            String message3="?˜¤?Š˜?˜ ë¬¼ê±´?“¤??? ëª¨ë‘ ?Œ”? ¸?Šµ?‹ˆ?‹¤. ?‹¤?Œ ë²ˆì— ë°©ë¬¸?•´ì£¼ì‹œê¸?.";
            DialogPanelController.show_dialog(message3);
            Answer answer1 = new Answer("1. ?ƒ?  ?‚˜ê°?ê¸?", "continue");
            DialogPanelController.show_dialog_answer1(answer1);
        }
    }
}