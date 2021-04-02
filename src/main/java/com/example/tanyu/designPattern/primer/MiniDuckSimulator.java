package com.example.tanyu.designPattern.primer;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/9 21:25
 */
public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        System.out.println("绿头鸭-------\n");
        mallard.performQuack();
        mallard.performFly();

        System.out.println("模型鸭-------\n");
        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();


    }
}
