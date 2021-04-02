package com.example.tanyu.designPattern.测试接口多实现问题;

public class Person implements IUser, ICountry {
    @Override
    public String name(String name) {
        return name;
    }
    

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.name("中国"));
    }
}
