package duke.command;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class ExitCommandTest {

    @Test
    public void isExitTest() {
        ExitCommand exit = new ExitCommand();
        assertTrue(exit.isExit());
    }
}
