package com;
import lombok.*;

import static com.Validator.isValidForProperty;

enum BossType {
    AZATHOTH("아자투스"),
    CHUTHULU("크툴루"),
    NYARLATHOTEP("니알라토텝");

    final private String name;
    private BossType(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

@Data
@Builder
public class Boss {
    private BossType name;
    private int health;
    private int power;

    public void setPower(int value) {
        if (isValidForProperty(value))
            this.power = value;
    }
    public void setHealth(int value) {
        if (isValidForProperty(value))
            this.health = value;
    }
    public static class BossBuilder{
        public BossBuilder power(int value){
            if (isValidForProperty(value))
                this.power = value;
            return this;
        }
        public BossBuilder health(int value){
            if (isValidForProperty(value))
                this.health = value;
            return this;
        }
    }
}
