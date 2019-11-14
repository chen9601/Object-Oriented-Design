package com;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 상점 객체 모델, 아이템을 살 때 필요한 각종 함수들이 모여있다. 일종의 핸들러이다.
 * @author Se-Ok Jeon
 * @version 1.0
 */
@Data
@Builder
public class Shop {
    // TODO : 아이템 리스트로 업데이트하고, 상점 다이얼로그 창에 띄워줄 항목들은 어떻게 결정할 지 정해야함.
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
        ArrayList<Item> player_items = player.getItems();
        player_items.add(item);
        player.setMoney(getChange(player, item));
        player.setItems(player_items);
    }
}
