package com.example.tanyu.huawei.hal;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * 输入描述:
 * 输入一个正浮点数值
 * 输出描述:
 * 输出该数值的近似整数值
 * <p>
 * 输入:5.5
 * 输出:6
 */
public class Approximation {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        double doubleNum = scanner.nextDouble();
//        int intNum =(int) doubleNum;
//        if(doubleNum - intNum >=0.5  && doubleNum - intNum < 1){
//            intNum ++;
//        }
//        System.out.println(intNum);

//        Scanner sc = new Scanner(System.in);
//        System.out.println((int) Math.round(sc.nextDouble()));

        Scanner scanner = new Scanner(System.in);
        double d = scanner.nextDouble();
        System.out.println((int) Math.round(d));


    }
}
