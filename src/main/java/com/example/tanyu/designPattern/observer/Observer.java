package com.example.tanyu.designPattern.observer;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/13 15:06
 */
public interface Observer {

    public void update(float temp, float humidity, float pressure);
}
