package com.rusakov.command;

import com.rusakov.ComputationState;

public class JumpIfZeroCommand extends Command {

    private final int jumpTo;

    public JumpIfZeroCommand(int jumpTo) {
        this.jumpTo = jumpTo;
    }

    @Override
    public void executeInternal(ComputationState computationState) {
        if (computationState.read() == 0) {
            computationState.jumpTo(jumpTo);
        }
    }

    public int getJumpTo() {
        return jumpTo;
    }
}
