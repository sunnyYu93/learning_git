package com.example.tanyu.designPattern.decoratorPattern;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/22 19:58
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return 0.20 + beverage.cost();
    }
}
