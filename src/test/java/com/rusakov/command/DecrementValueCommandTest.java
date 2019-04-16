package com.rusakov.command;

import com.rusakov.ComputationState;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class DecrementValueCommandTest {

    @Test
    public void execute() {
        ComputationState computationState = Mockito.mock(ComputationState.class);

        DecrementValueCommand decrementValueCommand = new DecrementValueCommand();
        decrementValueCommand.execute(computationState);

        verify(computationState).decrementValue();
    }
}
