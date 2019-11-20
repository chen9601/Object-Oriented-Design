package com;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;

/**
 * 타일 객체 모델, 각 타일은 자신의 소환된 몬스터나 차원문, 내부 이벤트를 관리한다.
 * @author Se-Ok Jeon
 * @version 1.0
 */
@Data
@Builder
public class Tile {
    @Builder.Default
    private ArrayList<Event> internal_events = new ArrayList<>();
    @Builder.Default
    private ArrayList<PortalGate> summoned_portals = new ArrayList<>();
    @Builder.Default
    private ArrayList<Monster> summoned_monsters = new ArrayList<>();
    private String name;

    // TODO : 테스팅
    void add_Summoned_monsters(Monster monster){
        this.summoned_monsters.add(monster);
    }
}
