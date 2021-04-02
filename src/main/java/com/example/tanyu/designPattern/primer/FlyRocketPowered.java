package com.example.tanyu.designPattern.primer;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/9 21:32
 */
public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("利用火箭飞行");
    }
}
