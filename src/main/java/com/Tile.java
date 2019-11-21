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
    // TODO : 우리 병원인거 확인은 그냥 if문으로 해야 하나? Tile내에 병원 같은 이벤트 여부를 확인하는 것 보다? 그게 편하려나?
//    @Builder.Default
//    private ArrayList<Event> internal_events = new ArrayList<>();
    private boolean summoned_portal;
    private Monster summoned_monster;
    private final TileType name;
}
