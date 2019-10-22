import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.RuntimeException;

class PlayerTest {
    public static Player player;

    @BeforeAll
    public static void makeInstance() throws Exception {
        player = Player
                .builder()
                .power(10)
                .dexterity(20)
                .health(30)
                .intelligence(40)
                .mental(50)
                .characteristics("test")
                .build();
    }

    @Test
    void isValidForProperty() {
        assertThrows(RuntimeException.class, ()->{player.isValidForProperty(-1);} );
        assertEquals(true, player.isValidForProperty(0101));
        assertEquals(true, player.isValidForProperty(017));
        assertThrows(RuntimeException.class, ()->{player.isValidForProperty(3.14);} );
    }

    @Test
    void setPower() {
        assertThrows(RuntimeException.class, ()->{player.setPower(-1);});
        assertThrows(RuntimeException.class, ()->{player.setPower(0x113);});
    }

    @Test
    void setDexterity() {
        assertThrows(RuntimeException.class, ()->{player.setDexterity(-1);});
        assertThrows(RuntimeException.class, ()->{player.setDexterity(0x113);});
    }

    @Test
    void setIntelligence() {
        assertThrows(RuntimeException.class, ()->{player.setIntelligence(-1);});
        assertThrows(RuntimeException.class, ()->{player.setIntelligence(0x113);});
    }

    @Test
    void setHealth() {
        assertThrows(RuntimeException.class, ()->{player.setHealth(-1);});
        assertThrows(RuntimeException.class, ()->{player.setHealth(0x113);});
    }

    @Test
    void setMental() {
        assertThrows(RuntimeException.class, ()->{player.setMental(-1);});
        assertThrows(RuntimeException.class, ()->{player.setMental(0x113);});
    }

    // TODO : 특성별 문자열 유효성 검사 수행하기!
    @Test
    void setCharacteristics() {
    }
}