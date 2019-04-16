package com.rusakov.command;

import com.rusakov.ComputationState;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class IncrementValueCommandTest {

    @Test
    public void execute() {
        ComputationState computationState = Mockito.mock(ComputationState.class);

        IncrementValueCommand incrementValueCommand = new IncrementValueCommand();
        incrementValueCommand.execute(computationState);

        verify(computationState).incrementValue();
    }
}
