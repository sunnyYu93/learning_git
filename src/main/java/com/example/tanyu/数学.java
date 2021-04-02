package com.example.tanyu;

import java.util.concurrent.Executors;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/3 20:29
 */
public class 数学 {
    static int a=6;
    static int d=0;
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        while (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(7);
        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(8);

    }

}
