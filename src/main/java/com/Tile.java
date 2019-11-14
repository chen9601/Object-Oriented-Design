package com;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;

@Data
@Builder
public class Tile {
    @Builder.Default
    private ArrayList<Event> internal_events = new ArrayList<>();
    @Builder.Default
    private ArrayList<PortalGate> summoned_portals = new ArrayList<>();
    @Builder.Default
    private ArrayList<Monster> summoned_monsters = new ArrayList<>();
    @NonNull
    private final String name;

    // TODO : 테스팅
    void add_Summoned_monsters(Monster monster){
        this.summoned_monsters.add(monster);
    }
}
