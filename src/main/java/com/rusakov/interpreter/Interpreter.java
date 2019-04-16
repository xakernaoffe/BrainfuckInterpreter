package com.rusakov.interpreter;

import com.rusakov.command.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Interpreter {

    private final List<Command> commands;

    public Interpreter(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InterpreterException("Command can't be null or empty");
        }
        this.commands = Collections.unmodifiableList(parse(input.toCharArray()));
    }

    private List<Command> parse(char[] tokens) {
        List<Command> commands = new ArrayList<>();
        int tokenIndex = 0;

        while (tokenIndex < tokens.length) {
            Instruction instruction = Instruction.getByToken(tokens[tokenIndex]);
            switch (instruction) {
                case INCREMENT_POINTER:
                    commands.add(new IncrementPointerCommand());
                    break;
                case DECREMENT_POINTER:
                    commands.add(new DecrementPointerCommand());
                    break;
                case INCREMENT_VALUE:
                    commands.add(new IncrementValueCommand());
                    break;
                case DECREMENT_VALUE:
                    commands.add(new DecrementValueCommand());
                    break;
                case PRINT:
                    commands.add(new PrintValueCommand());
                    break;
                case JUMP_IF_ZERO:
                    int endOfLoop = findEndOfLoop(tokenIndex, tokens);
                    commands.add(new JumpIfZeroCommand(endOfLoop));
                    break;
                case JUMP_IF_NOT_ZERO:
                    int startOfLoop = findStartOfLoop(tokenIndex, tokens);
                    commands.add(new JumpIfNotZeroCommand(startOfLoop));
                    break;
            }
            tokenIndex++;
        }
        return commands;
    }

    private int findEndOfLoop(int currentPosition, char[] tokens) {
        int depth = 1;
        while (depth != 0) {
            currentPosition++;

            if (currentPosition == tokens.length) {
                throw new InterpreterException("Can't find end of loop");
            }

            switch (Instruction.getByToken(tokens[currentPosition])) {
                case JUMP_IF_NOT_ZERO:
                    depth--;
                    break;
                case JUMP_IF_ZERO:
                    depth++;
                    break;
            }
        }
        return currentPosition;
    }

    private int findStartOfLoop(int currentPosition, char[] tokens) {
        int depth = 1;
        while (depth != 0) {
            currentPosition--;

            if (currentPosition < 0) {
                throw new InterpreterException("Can't find start of loop");
            }

            switch (Instruction.getByToken(tokens[currentPosition])) {
                case JUMP_IF_NOT_ZERO:
                    depth++;
                    break;
                case JUMP_IF_ZERO:
                    depth--;
                    break;
            }
        }
        return currentPosition;
    }

    public List<Command> getCommands() {
        return commands;
    }
}
