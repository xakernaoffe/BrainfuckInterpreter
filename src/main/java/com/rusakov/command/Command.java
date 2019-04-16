package com.rusakov.command;

import com.rusakov.ComputationState;

public abstract class Command {

    public void execute(ComputationState computationState) {
        executeInternal(computationState);
        computationState.completeCommand();
    }

    protected  abstract void executeInternal(ComputationState computationState);
}
