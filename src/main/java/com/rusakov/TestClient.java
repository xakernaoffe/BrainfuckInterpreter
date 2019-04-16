package com.rusakov;

import com.rusakov.interpreter.Interpreter;

public class TestClient {

    public static void main(String[] args) {
        String input = "----[---->+<]>++.--[----->+<]>+.[---->+<]>+++.++[--->++<]>.-------.----.--[--->+<]>--" +
                ".+.[---->+<]>+++.-[--->++<]>-.+++++++++++.[---->+<]>+++.--[->++++<]>-.--------.+++.-------.++++++++.";
        Interpreter interpreter = new Interpreter(input);
        new Executor(new byte[100]).execute(interpreter.getCommands());
    }
}
