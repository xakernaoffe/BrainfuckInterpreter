package com.rusakov.command;

import com.rusakov.ComputationState;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class PrintValueCommandTest {

    @Test
    public void execute() {
        ComputationState computationState = Mockito.mock(ComputationState.class);

        PrintValueCommand printValueCommand = new PrintValueCommand();
        printValueCommand.execute(computationState);

        verify(computationState).read();
    }
}
