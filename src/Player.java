import lombok.*;
import java.lang.RuntimeException;
@Getter
@Setter
@ToString
@Builder
public class Player {
    @Builder.Default private int power = 0;
    @Builder.Default private int dexterity = 0;
    @Builder.Default private int intelligence = 0;
    @Builder.Default private int health = 0;
    @Builder.Default private int mental = 0;
    @Builder.Default private String characteristics = "test";

    // TODO : 타입별 유효성 검사 수행하기!
    public boolean isValidForProperty(Object property) throws RuntimeException{
        final int MAX_PROPERTY = 99;
        if(property instanceof Integer){
            if ((Integer)property >= 0 && (Integer) property < MAX_PROPERTY){
                return true;
            }
        }
        throw new RuntimeException("잘못된 값이 입력되었습니다: " + property);
    }

    public static void main(String[] args){
        Player player = Player.builder()
                .power(-1)
                .build();
        String a = Integer.toBinaryString(96);
        Integer b = 01;
        Integer c = 0x12f;
        System.out.println(player.isValidForProperty(-1));
        System.out.println(player);
        System.out.println(b+"\n"+c);
    }
}
