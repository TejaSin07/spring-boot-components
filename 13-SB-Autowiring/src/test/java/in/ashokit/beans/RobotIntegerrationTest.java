package in.ashokit.beans;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RobotIntegrationTest {

    @Autowired
    private Robot robot;

    @Autowired
    private IChip chip;

    @Test
    void contextLoads() {
        // verifies Spring created real beans
        assertNotNull(robot);
        assertNotNull(chip);
    }

    @Test
    void testPrimaryChipIsInjectedAndWorks() {
        // since Chip32Bit is @Primary and returns true
        boolean status = chip.process();

        assertTrue(status);

        robot.doWork(); // real method, real bean
    }
}
