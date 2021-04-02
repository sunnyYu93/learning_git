package com.example.tanyu.designPattern.decoratorPattern;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/22 19:46
 */
public abstract class Beverage {
    double size = 0.0;

    public double getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
