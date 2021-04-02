package com.example.tanyu.designPattern.primer;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/9 21:09
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("鸭子在飞");
    }
}
