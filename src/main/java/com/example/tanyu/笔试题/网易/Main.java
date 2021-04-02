package com.example.tanyu.笔试题.网易;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            method(arr, n);
        }
    }

    public static void method(int[][] arr, int n) {
        if (n == 1) {
            System.out.println("1 1");
            return;
        }

        int[][] dp = new int[n][n];
        int[] dpA = new int[n];
        int[] dpB = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dpA[i] += arr[i][j];
                dpB[i] += arr[j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dpA[i] + dpB[j] - arr[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        int[] in = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    in[0] = i;
                    in[1] = j;
                }
            }
        }

        System.out.println((in[0] + 1) + " " + (in[1] + 1));

        int[][] array = new int[n - 1][n - 1];
        for (int i = 0, k = 0; i < n; i++) {
            if (in[0] != i) {
                for (int j = 0, t = 0; j < n; j++) {
                    if (in[1] != j) {
                        array[k][t++] = arr[i][j];
                    }
                }
                k++;
            }
        }

        method(array, n - 1);
    }
}
