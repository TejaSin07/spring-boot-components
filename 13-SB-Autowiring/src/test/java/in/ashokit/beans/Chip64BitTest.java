
package in.ashokit.beans;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Chip64BitTest {

    @Test
    void testProcess() {
        Chip64Bit chip = new Chip64Bit();
        assertTrue(chip.process());
    }
}
