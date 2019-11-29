package com;

import java.util.concurrent.TimeUnit;

public class Fight
{
    public void Normalfight(Player player, Monster monster) throws InterruptedException {
        //전투 창 불러오기
        while(true)
        {
            int temp=0;//주사위 굴리기
            if(temp>=monster.getRequireVal())
            {
                //전투 다이얼로그창에 입힌 데미지 출력
                monster.setHealth(monster.getHealth()-1);
            }
            else
            {
                //데미지를 입히지 못했다는 문구 출력
            }

            TimeUnit.SECONDS.sleep(10);

            if(monster.getHealth()<1)
            {
                //전투 승리 문구 출력
                player.setMoney(player.getMoney()+monster.getMonster_result());
                monster=null;
                break;
            }

            int temp2=0;//주사위 굴리기for monster
            if(temp2>=monster.getRequireVal())
            {
                //전투 다이얼로그창에 입힌 데미지 출력
                if(monster.getDamageType()==1)
                    player.setHealth(player.getHealth()-monster.getDamage());
                else if(monster.getDamageType()==2)
                    player.setMental(player.getMental()-monster.getDamage());
            }
            else
            {
                //데미지를 입히지 못했다는 문구 출력
            }

            TimeUnit.SECONDS.sleep(10);

            if(player.getHealth()<1)
            {
                //전투 패배 문구 출력
                player.setStatus(2);
                break;
            }
        }
        TimeUnit.SECONDS.sleep(10);
    }

    public static void BossFight()
    {

    }
}
