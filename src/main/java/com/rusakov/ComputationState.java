package com.rusakov;

public class ComputationState {

    private int pointerIndex = 0;
    private int commandIndex = 0;
    private final byte[] memory;

    public ComputationState(byte[] memory) {
        this.memory = memory;
    }

    public void incrementPointer() {
        pointerIndex++;
    }

    public void decrementPointer() {
        pointerIndex--;
    }

    public void incrementValue() {
        memory[pointerIndex] += 1;
    }

    public void decrementValue() {
        memory[pointerIndex] -= 1;
    }

    public byte read() {
        return memory[pointerIndex];
    }

    public void jumpTo(int to) {
        commandIndex = to;
    }

    public void completeCommand() {
        commandIndex++;
    }

    public int getCommandIndex() {
        return commandIndex;
    }
}
