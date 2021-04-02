package com.example.tanyu.huawei.hal;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * <p>
 * 输入描述:
 * 输入N个字符
 * <p>
 * 输出描述:
 * 输出该字符串反转后的字符串
 */
public class StringReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numString = scanner.nextLine();
        StringBuffer str = new StringBuffer(numString);
        str.reverse();
        System.out.println(str);
    }
}
