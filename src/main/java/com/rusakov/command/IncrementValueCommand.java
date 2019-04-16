package com.rusakov.command;

import com.rusakov.ComputationState;

public class IncrementValueCommand extends Command {
    @Override
    public void executeInternal(ComputationState computationState) {
        computationState.incrementValue();
    }
}
