package com.example.tanyu.huawei.hal;

import java.util.Scanner;

/**
 * 描述：
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */
public class DigitalUpsideDown {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String numString = scanner.nextLine();
//
//        //利用数组倒序玄幻遍历
//        char[] chars = numString.toCharArray();
//        String s = "";
//        for (int i = chars.length - 1; i >= 0; i--) {
//            s += chars[i];
//        }
//        System.out.println(s);
//
//
//        //第二种方法 利用反转函数
//        StringBuffer rs=new StringBuffer(numString);
//        rs.reverse();
//        System.out.println(rs);


        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();
        String s = "";
        for (int i = arr.length - 1; i >= 0; i--) {

            s += arr[i];
        }
        System.out.println(s);
    }
}
