package com;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tile {
    private Event internal_event;
    private Monster summoned_monster;
    private PortalGate summoned_portal;
}
