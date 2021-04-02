package com.example.tanyu.designPattern.observer;

import java.util.ArrayList;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/13 15:11
 */
public class WeatherDataCopy implements Subject {

    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataCopy() {
        observers = new ArrayList();
    }

    /**
     * 注册观察者
     * @param ob
     */
    @Override
    public void registerObserver(Observer ob) {
        observers.add(ob);

    }

    /**
     * 移除观察者
     * @param ob
     */
    @Override
    public void removeObserver(Observer ob) {
        int i = observers.indexOf(ob);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    /**
     * 将状态告诉每一个观察者
     */
    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature, humidity, pressure);

        }
    }

    /**
     * 气象者数据更新，通知每一个观察者
     */
    public void measurementsChanged() {
        notifyObserver();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

}
