package com.rusakov.command;

import com.rusakov.ComputationState;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class IncrementPointerCommandTest {

    @Test
    public void execute() {
        ComputationState computationState = Mockito.mock(ComputationState.class);

        IncrementPointerCommand incrementPointerCommand = new IncrementPointerCommand();
        incrementPointerCommand.execute(computationState);

        verify(computationState).incrementPointer();
    }
}
