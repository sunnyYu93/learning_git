package com.example.tanyu.designPattern.command;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/27 9:05
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
