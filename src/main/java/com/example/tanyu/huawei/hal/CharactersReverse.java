package com.example.tanyu.huawei.hal;

import java.util.Scanner;

/**
 * 字符串反转
 */
public class CharactersReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer(s);
        stringBuffer.reverse();
        System.out.println(stringBuffer);

    }
}
