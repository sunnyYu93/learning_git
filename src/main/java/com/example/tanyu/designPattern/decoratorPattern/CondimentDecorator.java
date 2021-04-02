package com.example.tanyu.designPattern.decoratorPattern;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/22 19:50
 */
public abstract class CondimentDecorator extends Beverage {

    public abstract String getDescription();

    @Override
    public double cost() {
        return 0;
    }
}
