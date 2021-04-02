package com.example.tanyu.笔试题.贝壳;

import java.util.Scanner;

public class 回文串构造 {
    public static int minPath(String str) {
        if (str.length() <= 1) {
            return 0;
        }

        int i = 0;
        int j = str.length() - 1;
        if (str.charAt(i) == str.charAt(j)) {
            return minPath(str.substring(i + 1, j - i + 1));
        } else {
            return Math.min(minPath(str.substring(i + 1, j - i - 1)),
                    Math.min(minPath(str.substring(i, j - i)), minPath(str.substring(i + 1, j - i)))) + 1;
        }


    }

    public static int minPath2(String str) {
        if (str.length() <= 1) {
            return 0;
        }

        int n = str.length();
        int[][] arr = new int[n+1][n+1];
        for (int i = n-2 ; i >= 0; i--) {
            for (int j = i +1; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    arr[i][j] = arr[i + 1][j - 1];
                } else {
                    arr[i][j] = Math.min(arr[i + 1][j - 1], Math.min(arr[i][j - 1], arr[i + 1][j])) + 1;
                }
            }
        }



        return arr[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        System.out.println(s);

//        System.out.println(minPath2(s));

//        if (str.length() <= 1) {
//            System.out.println(0);
//        }

//        int[][] arr = new int[n+1][n+1];
//        for (int i = n-2 ; i >= 0; i--) {
//            for (int j = i +1; j < n; j++) {
//                if (str.charAt(i) == str.charAt(j)) {
//                    arr[i][j] = arr[i + 1][j - 1];
//                } else {
//                    arr[i][j] = Math.min(arr[i + 1][j - 1], Math.min(arr[i][j - 1], arr[i + 1][j])) + 1;
//                }
//            }
//        }
    }
}
