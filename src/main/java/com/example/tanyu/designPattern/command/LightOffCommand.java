package com.example.tanyu.designPattern.command;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/27 9:38
 */
public class LightOffCommand implements Command {
    Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.off();
    }
}
