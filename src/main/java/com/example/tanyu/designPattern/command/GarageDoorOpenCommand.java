package com.example.tanyu.designPattern.command;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/27 9:14
 */
public class GarageDoorOpenCommand implements Command{
    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}
