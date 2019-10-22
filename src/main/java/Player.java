import lombok.*;
import java.lang.RuntimeException;

@Data
@Builder
public class Player {
    private int power;
    private int dexterity;
    private int intelligence;
    private int health;
    private int mental;
    private String characteristics;

    public static boolean isValidForProperty(Object property) throws RuntimeException{
        final int MAX_PROPERTY = 99;
        if(property instanceof Integer){
            if ((Integer)property >= 0 && (Integer) property < MAX_PROPERTY){
                return true;
            }
        }
        throw new RuntimeException("잘못된 값이 입력되었습니다: " + property);
    }

    public void setPower(int value) {
        if (isValidForProperty(value))
            this.power = value;
    }
    public void setDexterity(int value) {
        if (isValidForProperty(value))
            this.dexterity = value;
    }
    public void setIntelligence(int value) {
        if (isValidForProperty(value))
            this.intelligence = value;
    }
    public void setHealth(int value) {
        if (isValidForProperty(value))
            this.health = value;
    }
    public void setMental(int value) {
        if (isValidForProperty(value))
            this.mental = value;
    }
    public void setCharacteristics(String value) {
        this.characteristics = value;
    }

    public static class PlayerBuilder{

        public PlayerBuilder power(int value){
            if (isValidForProperty(value))
                this.power = value;
            return this;
        }
        public PlayerBuilder dexterity(int value){
            if (isValidForProperty(value))
                this.dexterity = value;
            return this;
        }
        public PlayerBuilder intelligence(int value){
            if (isValidForProperty(value))
                this.intelligence = value;
            return this;
        }
        public PlayerBuilder health(int value){
            if (isValidForProperty(value))
                this.health = value;
            return this;
        }
        public PlayerBuilder mental(int value){
            if (isValidForProperty(value))
                this.mental = value;
            return this;
        }
        // TODO : 특성별 문자열 유효성 검사 수행하기!
        public PlayerBuilder characteristics(String value){
            this.characteristics = value;
            return this;
        }
    }
}
