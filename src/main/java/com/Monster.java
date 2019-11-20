package com;

import lombok.Builder;
import lombok.Data;

/**
 * 몬스터의 기본 속성들을 정의하는 클래스
 * health:몬스터 체력
 * requireVal:몬스터에게 데미지를 주기 위한/몬스터가 플레이어에게 데미지를 주기 위한 주사위 요구치
 * damage:몬스터가 플레이어에게 주는 데미지
 * damageType:데미지 타입. 1체력, 2정신력
 * monsterresult:몬스터와의 전투 승리 시 얻을 수 있는 소지금 보상
 * name:몬스터 이름
 * @author Chanho Park, Se-ok Jeon
 */
@Data
@Builder
public class Monster
{
    public enum MonsterType{
        Nightgaunt("나이트건트"),
        Nephren_Ka("검은 파라오");

        final private String name;
        MonsterType(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }
    private int health;
    private int requireVal;
    private int damage;
    private int damageType;
    private int monster_result;
    private String name;

}