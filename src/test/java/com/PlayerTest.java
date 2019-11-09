package com;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.lang.RuntimeException;

class PlayerTest {
    public static Player player;

    @BeforeAll
    public static void makeInstance() throws Exception {
        player = Player
                .builder()
                .power(10)
                .dexterity(20)
                .health(30)
                .intelligence(40)
                .mental(50)
                .characteristics("test")
                .build();
    }

    @Test
    void test_moveTo(){
        assertEquals(TileType.C, player.moveTo(TileType.C));
    }
}