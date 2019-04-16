package com.rusakov.interpreter;

import com.rusakov.command.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InterpreterTest {

    @Test(expected = InterpreterException.class)
    public void shouldThrowInterpreterExceptionWhenInputIsNull() {
        new Interpreter(null);
    }

    @Test(expected = InterpreterException.class)
    public void shouldThrowInterpreterExceptionWhenInputIsEmpty() {
        new Interpreter(" ");
    }

    @Test(expected = InterpreterException.class)
    public void shouldThrowInterpreterExceptionWhenInputContainsInvalidToken() {
        new Interpreter("++-1>>");
    }

    @Test(expected = InterpreterException.class)
    public void shouldThrowInterpreterExceptionWhenInputContainsUnclosedLoop() {
        new Interpreter("++[--++.");
    }

    @Test(expected = InterpreterException.class)
    public void shouldThrowInterpreterExceptionWhenInputContainsNotOpenedLoop() {
        new Interpreter("++]-");
    }

    @Test
    public void shouldParseInput() {
        String input = "<>+-.++[.]";

        Interpreter interpreter = new Interpreter(input);

        assertThat(interpreter.getCommands()).hasSize(10);
        assertThat(interpreter.getCommands().get(0)).isInstanceOf(DecrementPointerCommand.class);
        assertThat(interpreter.getCommands().get(1)).isInstanceOf(IncrementPointerCommand.class);
        assertThat(interpreter.getCommands().get(2)).isInstanceOf(IncrementValueCommand.class);
        assertThat(interpreter.getCommands().get(3)).isInstanceOf(DecrementValueCommandTest.class);
        assertThat(interpreter.getCommands().get(4)).isInstanceOf(PrintValueCommand.class);
        assertThat(interpreter.getCommands().get(5)).isInstanceOf(IncrementValueCommand.class);
        assertThat(interpreter.getCommands().get(6)).isInstanceOf(IncrementValueCommand.class);

        assertThat(interpreter.getCommands().get(7)).isInstanceOf(JumpIfZeroCommand.class);
        assertThat(((JumpIfZeroCommand) interpreter.getCommands().get(7)).getJumpTo()).isEqualTo(9);

        assertThat(interpreter.getCommands().get(8)).isInstanceOf(PrintValueCommand.class);

        assertThat(interpreter.getCommands().get(9)).isInstanceOf(JumpIfNotZeroCommand.class);
        assertThat(((JumpIfNotZeroCommand) interpreter.getCommands().get(9)).getJumpTo()).isEqualTo(7);
    }
}
