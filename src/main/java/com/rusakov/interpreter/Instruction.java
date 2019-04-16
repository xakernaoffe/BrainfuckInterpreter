package com.rusakov.interpreter;

public enum Instruction {
    INCREMENT_POINTER('>'),
    DECREMENT_POINTER('<'),
    INCREMENT_VALUE('+'),
    DECREMENT_VALUE('-'),
    PRINT('.'),
    JUMP_IF_ZERO('['),
    JUMP_IF_NOT_ZERO(']');

    public final char token;

    Instruction(char token) {
        this.token = token;
    }

    public static Instruction getByToken(char token) {
        for (Instruction instruction : Instruction.values()) {
            if (instruction.token == token) {
                return instruction;
            }
        }
        throw new InterpreterException(String.format("Illegal token `%s`", token));
    }
}
