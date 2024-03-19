import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class UITest {

    private UI ui;

    @BeforeEach
    void setUp() {
        ui = new UI(new PersonManager());
    }

    @Test
    void testCheckNameWithNumber() {
        assertThrows(InvalidPersonNameException.class, () -> ui.checkName("Natalie2"));
    }

    @Test
    void testCheckNameWithoutNumber() {
        assertDoesNotThrow(() -> ui.checkName("Natalie"));
    }

    @Test
    void testCheckDataWithNumber() {
        assertDoesNotThrow(() -> ui.checkData("123"));
    }

    @Test
    void testCheckDataWithoutNumber() {
        assertThrows(NumberFormatException.class, () -> ui.checkData("abcABC"));
    }
}
