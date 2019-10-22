package com;
import lombok.*;

import static com.Validator.isValidForProperty;

@Data
@Builder
public class Boss {
    private BossName name;
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
