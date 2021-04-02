package com.example.tanyu.designPattern.decoratorPattern;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/22 20:07
 */
public class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
