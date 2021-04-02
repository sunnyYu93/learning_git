package com.example.tanyu.designPattern.decoratorPattern;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/22 20:03
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    public double cost() {
        return 0.10 + beverage.cost();
    }
}
