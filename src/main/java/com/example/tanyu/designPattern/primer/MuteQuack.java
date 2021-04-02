package com.example.tanyu.designPattern.primer;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/9 21:11
 */
public class MuteQuack implements QuackBehvior {
    @Override
    public void quack() {
        System.out.println("不会叫");
    }
}
