package com.example.tanyu.designPattern.primer;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/9 21:30
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        //实现关系下的多态：
        //接口实现多态
        //接口  变量  = new  接口实现类的对象。
        quackBehvior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("我是一个模型鸭");
    }
}
