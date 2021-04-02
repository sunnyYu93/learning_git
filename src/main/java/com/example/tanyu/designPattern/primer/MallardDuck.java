package com.example.tanyu.designPattern.primer;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/9 21:05
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehvior  = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("这是一只绿头鸭");
    }



}
