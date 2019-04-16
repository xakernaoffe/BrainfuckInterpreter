package com.rusakov;

import com.rusakov.command.Command;

import java.util.List;

public class Executor {

    private final ComputationState computationState;

    public Executor(byte[] memory) {
        this.computationState = new ComputationState(memory);
    }

    public void execute(List<Command> commands) {
        while (computationState.getCommandIndex() < commands.size()) {
            commands.get(computationState.getCommandIndex()).execute(computationState);
        }
    }
}
