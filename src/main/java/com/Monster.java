package com;

import lombok.Builder;
import lombok.Data;

/**
 * 몬스터의 기본 속성들을 정의하는 클래스
 *
 * @author Chanho Park, Se-ok Jeon
 */
@Data
@Builder

public class Monster {
//    monsterlist[0].name="나이트건트";monsterlist[0].health=3;monsterlist[0].requireVal=3;monsterlist[0].damage=1;monsterlist[0].damageType=1;monsterlist[0].monsterresult=3;
//    monsterlist[1].name="검은파라오";monsterlist[1].health=1;monsterlist[1].requireVal=6;monsterlist[1].damage=2;monsterlist[1].damageType=2;monsterlist[1].monsterresult=5;
//    monsterlist[2].name="비야키";monsterlist[2].health=2;monsterlist[2].requireVal=2;monsterlist[2].damage=1;monsterlist[2].damageType=1;monsterlist[2].monsterresult=1;
//    monsterlist[3].name="구울";monsterlist[3].health=4;monsterlist[3].requireVal=4;monsterlist[3].damage=2;monsterlist[3].damageType=1;monsterlist[3].monsterresult=4;
//    monsterlist[4].name="옛 것";monsterlist[0].health=5;monsterlist[0].requireVal=4;monsterlist[0].damage=1;monsterlist[0].damageType=2;monsterlist[0].monsterresult=5;

    static private Monster[] monsters;

    public enum MonsterType {
        Nightgaunt("나이트건트", 3, 3, 1, 1, 3),
        Dark_Paraoh("검은 파라오", 1, 6, 2, 2, 5),
        Byakhee("비야키", 2, 2, 1, 1, 1),
        Ghoul("구울", 4, 4, 2, 1, 4),
        Elder_Thing("옛 것", 5, 4, 1, 2, 5);

        private String name;
        private int initial_health;
        private int initial_requireVal;
        private int initial_damage;
        private int initial_damageType;
        private int initial_monster_result;


        MonsterType(String name, int health, int requireVal, int damage, int damageType, int monster_result) {
            this.name = name;
            this.initial_health = health;
            this.initial_requireVal = requireVal;
            this.initial_damage = damage;
            this.initial_damageType = damageType;
            this.initial_monster_result = monster_result;

        }


        public String getName() {
            return name;
        }

        public int getInitial_health() {
            return initial_health;
        }

        public int getInitial_requireVal() {
            return initial_requireVal;
        }

        public int getInitial_damage() {
            return initial_damage;
        }

        public int getInitial_damageType() {
            return initial_damageType;
        }

        public int getInitial_monster_result() {
            return initial_monster_result;
        }
    }

    private String name;
    private int health;
    private int requireVal;
    private int damage;
    private int damageType;
    private int monster_result;

    public void decreaseHealth(int damage_from_player) {
        health -= damage_from_player;
    }


}
