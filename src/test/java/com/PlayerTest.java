package com;

import org.junit.jupiter.api.BeforeAll;

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

}