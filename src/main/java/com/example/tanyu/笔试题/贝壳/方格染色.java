package com.example.tanyu.笔试题.贝壳;

import java.util.Scanner;

public class 方格染色 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[][] input = new int[T][2];
        int[] output = new int[T];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 2; j++) {
                input[i][j] = in.nextInt();
            }

        }

        for (int i = 0; i < T; i++) {
            int n = input[i][0];
            int m = input[i][1];
            if (n % 2 == 0 || m % 2 == 0) {
                output[i] = 2;
            } else if (n == 1 || m == 1) {

                if (n == 1) {
//                    output[i] = Math.max(n, m);
                    output[i] = m;
                    for (int j = m-1; j > 2; j--) {
                        if (j % 2 == 0) {
                            continue;
                        }

                        int y = m % j;
                        if (y == 0) {
                            output[i] = m / j;
                            break;
                        }
                    }
                }  else {
                    output[i] = n;
                    for (int j = n-1; j >2; j--) {
                        if (j % 2 == 0) {
                            continue;
                        }

                        int y = n % j;
                        if (y == 0) {
                            output[i] = n / j;
                            break;
                        }
                    }
                }
            }else {
                int h=Math.min(n,m);
                output[i] = h;
                for (int j = h-1; j >2; j--) {
                    if (j % 2 == 0) {
                        continue;
                    }

                    int y = h % j;
                    if (y == 0) {
                        output[i] = h / j;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(output[i]);
        }
    }
}
