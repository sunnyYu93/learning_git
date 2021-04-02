package com.example.tanyu.leetcode.数学;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 素数拆分 {

    static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void getPrime(int n, List<Integer> list) {
        if (n < 2) {
            return;
        }
        if (n <= 3) {
            list.add(n);
            return;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n - i == 1) {
                continue;
            }
            if (isPrime(i) && isPrime(n - i)) {
                getPrime(i, list);
                getPrime(n - i, list);
            }
        }
    }

    static boolean cut(int n) {
        for (int j = 2; j <= n / 2; j++) {
            if (isPrime(n) && isPrime(n - j)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < length; i++) {

            if (cut(array[i])) {
                getPrime(array[i], list);
            } else if (isPrime(array[i])) {
                list.add(array[i]);
            }
        }

        System.out.println(list.toString());
    }
}
