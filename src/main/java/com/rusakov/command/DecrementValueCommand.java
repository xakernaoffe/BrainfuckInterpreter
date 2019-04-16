package com.rusakov.command;

import com.rusakov.ComputationState;

public class DecrementValueCommand extends Command {
    @Override
    public void executeInternal(ComputationState computationState) {
        computationState.decrementValue();
    }
}
