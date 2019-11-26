package com;

import lombok.Builder;
import lombok.Data;

/**
 * 아이템 객체 모델
 *
 * @author Se-Ok Jeon
 * @version 1.0
 */
public enum ItemType {
    EXCALIBUR("엑스칼리버", 2, 1, 0, 1, 0, 5),
    NECRONOMICON("네크로노미", 0, 0, 4, 0, -1, 5),
    SHININGANISOTROPICAMY("빛나는 부등변다면체", 1, 1, 1, 1, 1, 5),
    GOLDENHONEYLIQUOR("황금의 벌꿀술", 2, 0, 0, 2, 0, 5),
    PROBLEMOFTIME("시간의문제", 0, 0, 2, 0, 2, 5),
    POWDEROFEVENBRANCH("이븐의 가지 분말", 1, 1, 1, 0, 0, 3),
    AMULETOFHOWARD("사냥개 부적", 2, 2, 2, -2, -2, 4),
    KEYOFWISDOM("지혜의 열쇠", 0, 0, 3, 0, 0, 3),
    SWEETLIQUOROFSPACE("우주의 감로주", 1, 1, 0, 2, 0, 5),
    HEADOFBLACKPHARAOH("검은파라오의 단장", 0, 0, 0, 0, 1, 1),
    LAMPOFALHAZARD("알하자드의 램프", 0, 2, 1, 0, 0, 4),
    TOMMYGUN("토미건",2,0,0,0,0,3),
    KNIFE("제사용 단검",1,0,0,0,1,2),
    HANZOSWORD("핫토리한조의 검",2,2,0,0,0,5),
    M16("M16",3,0,0,0,0,3);
    private int p_power;
    private int p_dex;
    private int p_int;
    private int p_health;
    private int p_mental;
    private String name;
    private int price;

    ItemType(String name, int p_power, int p_dex, int p_int, int p_health, int p_mental, int price) {
        this.name = name;
        this.p_power = p_power;
        this.p_dex = p_dex;
        this.p_int = p_int;
        this.p_health = p_health;
        this.p_mental = p_mental;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return p_power;
    }

    public int getDex() {
        return p_dex;
    }

    public int getInt() {
        return p_int;
    }

    public int getHealth() {
        return p_health;
    }

    public int getMental() {
        return p_mental;
    }

    public int getPrice() {
        return price;
    }
}
