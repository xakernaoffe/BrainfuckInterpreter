package com.rusakov.command;

import com.rusakov.ComputationState;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class DecrementPointerCommandTest {

    @Test
    public void execute() {
        ComputationState computationState = Mockito.mock(ComputationState.class);

        DecrementPointerCommand decrementPointerCommand = new DecrementPointerCommand();
        decrementPointerCommand.execute(computationState);

        verify(computationState).decrementPointer();
    }
}
