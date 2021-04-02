package com.example.tanyu.leetcode.数学;

import java.util.Scanner;

public class 神奇地铁站 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int tenValue = Integer.parseInt(String.valueOf(a), 2);

        int num = 0;
        while (tenValue != 0) {
            num++;
            tenValue = tenValue >> 1;
        }

        if (num % 4 == 0) {
            System.out.println(num / 2 -1);
        } else {
            System.out.println(num / 2);
        }

    }
}
