package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    public static Map map;
    public static Monster ghoul = Monster
                                    .builder()
                                    .name("Ghoul")
                                    .build();

    @BeforeEach
    void setUp() {
        map = Map.getInstance();
    }

    @Test
    void test_addMonstersAt(){
        // 몬스터 추가 후에, 해당 몬스터가 잘 있나?
        map.addMonstersAt(TileType.A, ghoul);
        assertEquals(
                new ArrayList<Monster>(Arrays.asList(ghoul)),
                Map.getMonstersAt(TileType.A)
        );
    }

    @Test
    void test_setMonstersAt(){
        map.setMonstersAt(TileType.A, new ArrayList<Monster>());
        assertEquals(
                new ArrayList<Monster>(),
                Map.getMonstersAt(TileType.A)
        );
    }

    @Test
    void test_getMonstersAt(){
        // 아무것도 없을 때
        assertEquals(new ArrayList<Monster>(), Map.getMonstersAt(TileType.A));

        // 몬스터가 하나 생성되고 나서 잘 나오나?
        map.getTiles().get(TileType.A.ordinal()).add_Summoned_monsters(ghoul);
        assertEquals(
                new ArrayList<Monster>(Arrays.asList(ghoul)),
                Map.getMonstersAt(TileType.A)
        );

        // map 객체가 싱글톤 패턴으로 제작되어, 이 테스트에서 발생한 변화가 다른 테스트에 영향을 준다. 따라서 초기화 해야함.
        map.setMonstersAt(TileType.A, new ArrayList<Monster>());
    }

}