package com.example.tanyu.designPattern.decoratorPattern;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/22 20:02
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage, double size) {
        this.beverage = beverage;
        this.size = size;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double cost() {
        return 0.15 + beverage.cost() + size;
    }
}
