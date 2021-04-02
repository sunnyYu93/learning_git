package com.example.tanyu.笔试题.网易;


import java.util.Scanner;

public class 七星不靠 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            StringBuilder s = new StringBuilder();
//            for (int j = 0; j < 7; j++) {
//                s.append(in.next()).append(" ");
//            }
//            if (isSuccess(s.toString())) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//        }

        System.out.println(isSuccess("1T 2T 3T 3B 6B 9B 9W"));


    }

    private static boolean isSuccess(String s) {
        String[] s1 = s.split(" ");
        int[] r = new int[10];
        StringBuilder t = new StringBuilder();
        StringBuilder w = new StringBuilder();
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < s1.length; i++) {
            String string = s1[i];
            if (string.charAt(1) == 'T') {
                if (r[string.charAt(0) - '0'] != 0) {
                    return false;
                } else {
                    r[string.charAt(0) - '0'] = 1;
                }

                t.append(string.charAt(0));
            } else if (string.charAt(1) == 'W') {
                if (r[string.charAt(0) - '0'] != 0) {
                    return false;
                } else {
                    r[string.charAt(0) - '0'] = 2;
                }

                w.append(string.charAt(0));
            } else if (string.charAt(1) == 'B') {
                if (r[string.charAt(0) - '0'] != 0) {
                    return false;
                } else {
                    r[string.charAt(0) - '0'] = 3;
                }

                b.append(string.charAt(0));
            }
        }

        if (t.length() > 3 || w.length() > 3 || b.length() > 3) {
            return false;
        }

        for (int i = 1; i < 4; i++) {
            int m = r[i];
            if (m == 0) {
                continue;
            }

            return (r[i + 3] == m || r[i + 3] == 0) && (r[i + 6] == m || r[i + 6] == 0);
        }

        return true;
    }
}
