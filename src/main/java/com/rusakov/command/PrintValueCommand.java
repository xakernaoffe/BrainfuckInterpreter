package com.rusakov.command;

import com.rusakov.ComputationState;

public class PrintValueCommand extends Command {
    @Override
    public void executeInternal(ComputationState computationState) {
        System.out.print((char) computationState.read());
    }
}
