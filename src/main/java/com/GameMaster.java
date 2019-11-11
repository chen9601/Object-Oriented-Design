package com;

import lombok.*;

@Data
@Builder
public class GameMaster {
    @Builder.Default
    private static int idx_of_cur_player = 0;
    private static final int maximum_num_of_players = 2;
    private static Player[] players = new Player[maximum_num_of_players];

    private void initiatePlayers() {
        for(int i = 0; i<2; i++){
            players[i] = Player
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

    public void initiateGame(){
        initiatePlayers();
    }

    public Player getCurrentPlayer(){
        return players[idx_of_cur_player];
    }

    public TileType moveTo(Player player, TileType here) {
        player.setPos(here);
        return player.getPos();
    }
}
