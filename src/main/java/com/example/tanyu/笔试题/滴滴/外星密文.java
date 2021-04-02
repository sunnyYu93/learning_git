package com.example.tanyu.笔试题.滴滴;

import java.util.Arrays;
import java.util.Scanner;

public class 外星密文 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();

        char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i = i + n) {
                reverse(charArray, i, i + n - 1);
            }


        System.out.println(Arrays.toString(charArray));
    }

    public static void reverse(char[] chars, int left, int right) {
        if (right >= chars.length) {
            right = chars.length - 1;
        }
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
