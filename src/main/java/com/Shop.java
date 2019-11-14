package com;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Shop {
    private Item item;

    // 상점에서 아이템을 고르기 위해 선택지를 클릭 할 때, 이 함수부터 체크하여 구매가능한지 확인한 후 진행한다.
    public static boolean isAffordable(Player player, Item item) {
        return player.getMoney() > item.getPrice();
    }

    public static int getChange(Player player, Item item) {
        return player.getMoney() - item.getPrice();
    }


    public void sellItem(Item item, Player player) throws RuntimeException {
        if(!Shop.isAffordable(player, item))
            throw new RuntimeException("현재 플레이어는 해당 아이템을 구매할 수 없습니다.");
        List<Item> player_items = player.getItems();
        player_items.add(item);
        player.setMoney(getChange(player, item));
        player.setItems(player_items);
    }
}
