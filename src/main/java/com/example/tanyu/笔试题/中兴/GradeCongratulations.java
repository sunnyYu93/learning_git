package com.example.tanyu.笔试题.中兴;

import java.util.Scanner;

public class GradeCongratulations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n个人
        int n = sc.nextInt();
        // m个科目
        int m = sc.nextInt();

        int[][] arr = new int[m][n];
        while (sc.hasNext()) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

        }


        int[] advntage = new int[n];
        for (int i = 0; i < m; i++) {
            int grade = 0;
            for (int j = 0; j < n; j++) {
                arr[i][j] += grade;
            }
            advntage[i] = grade / 2;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (advntage[j] < arr[i][j]) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);

    }
}
