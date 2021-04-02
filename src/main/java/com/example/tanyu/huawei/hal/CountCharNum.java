package com.example.tanyu.huawei.hal;

import java.util.Scanner;

public class CountCharNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numString = scanner.nextLine();
        char[] chars = numString.toCharArray();
        String s = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            s += chars[i];
        }
        System.out.println(s);
    }
}
