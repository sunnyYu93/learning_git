package com.example.tanyu.designPattern.observer.javanew;

import com.example.tanyu.designPattern.observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/13 16:20
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    Observable observable;

    private float temperature;

    private float humidity;
    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions" + temperature + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
