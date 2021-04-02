package com.example.tanyu.designPattern.primer;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/9 21:07
 */
public class Quack implements QuackBehvior {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
