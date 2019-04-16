package com.rusakov.command;

import com.rusakov.ComputationState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class JumpIfNotZeroCommandTest {

    private static final int JUMP_TO = 5;

    private ComputationState computationState;

    @Before
    public void setUp() {
        computationState = Mockito.mock(ComputationState.class);
    }

    @Test
    public void shouldDoNothingWhenCurrentValueIsZero() {
        when(computationState.read()).thenReturn(new Byte("0"));

        new JumpIfNotZeroCommand(JUMP_TO).execute(computationState);

        verify(computationState, never()).jumpTo(JUMP_TO);
    }

    @Test
    public void shouldCallJumpToWhenCurrentValueIsZero() {
        when(computationState.read()).thenReturn(new Byte("1"));

        new JumpIfNotZeroCommand(JUMP_TO).execute(computationState);

        verify(computationState).jumpTo(JUMP_TO);
    }
}
