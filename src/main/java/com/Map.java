package com;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

/**
 * 맵 객체 모델로, 맵의 부분 개념인 타일을 보다 쉽게 접근하는데 사용된다.(일종의 핸들러)
 *
 * @author Se-Ok Jeon
 * @version 1.0
 */
@Data
public final class Map {

    static final private Map map = new Map();
    static private ArrayList<Tile> tiles; // tiles의 인덱스 == TileType의 인덱스 : 각 타일 접근성 향상을 위해

    private Map(){
        tiles = new ArrayList<>(){};
        for( TileType tile : TileType.values() ){
            tiles.add(
                    Tile
                    .builder()
                    .name(tile.getName())
                    .build()
            );
        }
    }

    public static Map getInstance(){
        return map;
    }

    public static ArrayList<Monster> getMonstersAt(TileType pos) {
        Tile tile = tiles.get(pos.ordinal());
        return tile.getSummoned_monsters();
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public void addMonstersAt(TileType pos, Monster monster) {
        ArrayList<Monster> monsters = tiles.get(pos.ordinal()).getSummoned_monsters();
        monsters.add(monster);
        setMonstersAt(pos, monsters);
    }

    public void setMonstersAt(TileType pos, ArrayList<Monster> monsters) {
        Tile tile = tiles.get(pos.ordinal());
        tile.setSummoned_monsters(monsters);
    }
}
