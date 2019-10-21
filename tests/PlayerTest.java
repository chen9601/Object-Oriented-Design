import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.RuntimeException;

class PlayerTest {
    public static Player player;

    @BeforeAll
    public static void makeInstance() throws Exception {
        player = Player.builder().build();
    }

    @Test
    void isValidForProperty() {
        Player player = Player.builder().build();
        assertThrows(RuntimeException.class, ()->{player.isValidForProperty(-1);} );
        assertEquals(true, player.isValidForProperty(0101));
        assertEquals(true, player.isValidForProperty(0x113));
        assertEquals(true, player.isValidForProperty(017));
        assertThrows(RuntimeException.class, ()->{player.isValidForProperty(3.14);} );
    }

    @Test
    void setPower() {
        player.setPower(10);
        assertEquals(10, player.getPower());
    }

    @Test
    void setDexterity() {
    }

    @Test
    void setIntelligence() {
    }

    @Test
    void setHealth() {
    }

    @Test
    void setMental() {
    }

    @Test
    void setCharacteristics() {
    }
}