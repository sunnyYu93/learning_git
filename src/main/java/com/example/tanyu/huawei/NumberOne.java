package com.example.tanyu.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/4/29 19:04
 */
public class NumberOne {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s==null||"".equals(s)) {
            System.out.println(0);
        } else {
            char[] chars = s.toCharArray();
            int sum = 1;
            for (int i = 1; i<=chars.length; i++) {
                sum = sum * i;
            }
            System.out.println(sum);
        }


    }
}
