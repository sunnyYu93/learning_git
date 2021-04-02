package com.example.tanyu.designPattern.decoratorPattern;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/22 20:05
 */
public class DarkRoast extends Beverage{
    public DarkRoast() {
        description = "DarkRoast";
    }
    @Override
    public double cost() {
        return 0.99;
    }
}
