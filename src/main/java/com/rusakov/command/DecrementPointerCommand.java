package com.rusakov.command;

import com.rusakov.ComputationState;

public class DecrementPointerCommand extends Command {
    @Override
    public void executeInternal(ComputationState computationState) {
        computationState.decrementPointer();
    }
}
