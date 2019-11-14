package com;
import lombok.*;

import static com.Validator.isValidForProperty;

@Data
@Builder
public class Boss {
    /**
     * 보스에 관한
     */
    public enum BossType {
        AZATHOTH("아자투스"),
        CHUTHULU("크툴루"),
        NYARLATHOTEP("니알라토텝");

        final private String name;
        BossType(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
    }
    private BossType name;
    private int health;
    private int power;
}
