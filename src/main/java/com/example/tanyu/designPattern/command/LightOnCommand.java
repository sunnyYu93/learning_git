package com.example.tanyu.designPattern.command;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/27 9:03
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
