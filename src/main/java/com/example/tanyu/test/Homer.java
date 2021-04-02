package com.example.tanyu.test;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/29 10:05
 */
public class Homer {
    private final int[] a = {1, 2, 3};

    private static int[] b = {1, 1, 1};

    son son;

    int with(final int i) {
        return i + 9;
    }

    public static void main(String[] args) {
        int with = new Homer().with(1);

    }

}

final class son {
     int i = 8;
     void test(int p) {
        i = p;

    }

}
