package com.example.tanyu.designPattern.primer;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/9 20:58
 */
public abstract class Duck {

    FlyBehavior flyBehavior;

    QuackBehvior quackBehvior;

    public Duck() {
    }

    public abstract void display();

    public void performQuack() {
        quackBehvior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void swim() {
        System.out.println("所有的鸭子都会游泳");
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehvior(QuackBehvior qb) {
        quackBehvior = qb;
    }
}
