package com;

import static com.Map.*;

/**
 * 특정 조건에서 반드시 일어나야하는 이벤트들을 정리한 클래스
 * @author Chanho Park
 */
public class ConstantEventHandler
{
    void generateRandomEvent(){}
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
    void movebyTeleport(Player player, TileType tile){}
    /**
     * 움직일 플레이어와 목적지를 받아 이동가능 여부를 확인 후 이동시키는 메소드
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
//            Hospital();
        }

        if(tile == TileType.MENTAL_HOSTPITAL)
        {
//            Mospital();
        }

        if(tile == TileType.STORE)
        {
//            Shop();
        }

    }
    void addItem(Player player, Item item){}
    void deleteItem(Player player, Item item){}
    void addRandomItem(Player player){}
    void hospital(Player player){}
    void mospital(Player player){}
    void generalFight(Monster monster){}
    boolean isAffordable(Player player, Item.ItemType item){return true;}
    int getChange(Player player, Item.ItemType item){return 0;}
    void sellItem(Player player, Item.ItemType item){}
    Item getItem(Item.ItemType item){return null;}
    Item[] getRandomItemList(){return null;}

}