package com.example.tanyu.designPattern.observer;

import com.example.tanyu.designPattern.observer.javanew.CurrentConditionsDisplay;
import com.example.tanyu.designPattern.observer.javanew.WeatherData;

import java.sql.Statement;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/13 15:32
 */
public class WeatherStation {
    public static void main(String[] args) {
//        WeatherData weatherData = new WeatherData();
//        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
//        weatherData.setMeasurements(80, 65, 30.4f);
//        weatherData.setMeasurements(82, 70, 29.2f);
//        weatherData.setMeasurements(78, 90, 29.2f);

        float a= 2000000000.0f;
        float b= a+ 50;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a==b);


    }
}
