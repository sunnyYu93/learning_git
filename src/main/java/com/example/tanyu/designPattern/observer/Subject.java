package com.example.tanyu.designPattern.observer;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/13 15:05
 */
public interface Subject {

    public void registerObserver(Observer ob);

    public void removeObserver(Observer ob);

    public void notifyObserver();
}
