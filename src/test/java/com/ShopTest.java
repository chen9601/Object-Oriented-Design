package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    Item item;
    GameMaster gamemaster;
    Player cur_player;
    Shop shop;
    @BeforeEach
    void setUp() {
        item = Item
                .builder()
                .price(100)
                .build();

        gamemaster = GameMaster
                .builder()
                .build();
        gamemaster.initiateGame();
        cur_player = gamemaster.getCurrentPlayer();

        shop = Shop
                .builder()
                .build();
    }

    @Test
    void test_isAffordable(){
        assertEquals(
                cur_player.getMoney() > item.getPrice(),
                shop.isAffordable(cur_player, item)
                );
    }

    @Test
    void test_getChange(){
        int real_change = cur_player.getMoney() - item.getPrice();
        assertEquals(
                real_change,
                shop.getChange(cur_player, item)
        );

        assertEquals(
                real_change,
                cur_player.getMoney()
        );
    }
}