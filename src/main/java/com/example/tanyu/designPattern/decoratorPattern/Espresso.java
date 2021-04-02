package com.example.tanyu.designPattern.decoratorPattern;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/22 19:53
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
