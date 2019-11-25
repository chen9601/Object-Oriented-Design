package src;

public class ConstantEventHandler
{
    Map m;
    /**
     * 움직일 플레이어와 목적지를 받아 이동가능 여부를 확인 후 이동시키는 메소드
     * @param player
     *        해당 플레이어
     * @param tile
     *        목적지
     */
    public void Move(Player player, TileType tile, Map map)
    {
        int valid=m.pathValid(player.pos, tile);

        if(valid==1)
        {
            player.pos=tile;
            CheckEventHere(player, tile, map);
        }
        else if(valid==0)
        {
            ShowDialog("이동할 수 없는 곳입니다");
        }
    }

    public void CheckEventHere(Player player, TileType tile, Map map)
    {
        if(map.tiles[tile.getIndex()].summoned_portals==true)
        {
            GenerateFight(player);
            if(player.health>0)
            {
                token++;                                                            //토큰 어디 있는 속성인지 확인 요망
                map.tiles[tile.getIndex()].summoned_portals=false;
            }
        }

        if(map.tiles[tile.getIndex()].summoned_monsters!=null)
        {
            GenerateFight();
            if(player.health>0)
            {
                map.tiles[tile.getIndex()].summoned_monsters=null;
            }
        }

        if(tile.getName()=="병원")
        {
            Hospital();
        }

        if(tile.getName()=="정신병원")
        {
            Mospital();
        }

        if(tile.getName()=="상점")
        {
            Shop();
        }

    }

}