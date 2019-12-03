package com;

public class Fight_boss_controller {
    public static void attackedPlayerByBoss() {

        Player player = Player.getCurrentPlayer();
        int temp2 = ConstantEventHandler.Dice();
        Boss boss = GameMaster.current_boss;
        if (temp2 > boss.getRequireVal()) {
            player.setHealth(player.getHealth() - boss.getDamage());
        }
        if (player.getHealth() < 1) {
            System.out.println("플레이어 패배");
        }
    }

    public static void attackedBossByPlayer() {

        int temp = ConstantEventHandler.Dice();
        Boss boss = GameMaster.current_boss;
        if (temp > boss.getRequireVal()) {
            boss.setHealth(boss.getHealth() - (temp - boss.getRequireVal()));
        }

        if (boss.getHealth() < 1) {
            System.out.println("플레이어 패배");
        }

    }

    public static void Endlessfight(){
        while(Player.getCurrentPlayer().getHealth() !=0&&GameMaster.current_boss.getHealth() !=0){
            attackedBossByPlayer();
            attackedPlayerByBoss();
        }
    }

}
 timer.schedule(new TimerTask() {
@Override
public void run() {
        Dice.dispose();
        }
        },1*2*1000);