package in.ashokit.beans;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RobotTest {


    @Mock
    private IChip chip;

    @InjectMocks
    private Robot robot;

    @Test
    void testDoWork_WhenChipWorks() {
        when(chip.process()).thenReturn(true);

        robot.doWork();

        verify(chip).process();
    }

    @Test
    void testDoWork_WhenChipFails() {
        when(chip.process()).thenReturn(false);

        robot.doWork();

        verify(chip).process();
    }
}
