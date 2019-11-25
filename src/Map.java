package src;



public class Map
{
    private int[][] Path={
        {2,1,1,1,1,1,1,0,0,0,0,0,0},
        {1,2,1,0,0,0,1,1,1,0,0,0,0},
        {1,1,2,1,0,0,0,0,1,1,0,0,0},
        {1,0,1,2,1,0,0,0,0,1,1,0,0},
        {1,0,0,1,2,1,0,0,0,0,1,1,0},
        {1,0,0,0,1,2,1,0,0,0,0,1,1},
        {1,1,0,0,0,1,2,1,0,0,0,0,1},
        {0,1,0,0,0,0,1,0,0,0,0,0,0},
        {0,1,1,0,0,0,0,0,0,0,0,0,0},
        {0,0,1,1,0,0,0,0,0,0,0,0,0},
        {0,0,0,1,1,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,1,0,0,0,0,0,0,0},
        {0,0,0,0,0,1,1,0,0,0,0,0,0}
    };

    Tile[] tiles=new Tile[13];

    public int pathValid(TileType Curpos, TileType Nxtpos)
    {
        if(Path[Curpos.getIndex()][Nxtpos.getIndex()]==1)
        return 1;
        else if(Path[Curpos.getIndex()][Nxtpos.getIndex()]==2)
        return 2;
        else
        return 0;
    }

    Map(){}
}