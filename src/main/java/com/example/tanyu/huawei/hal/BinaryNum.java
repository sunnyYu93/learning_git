package com.example.tanyu.huawei.hal;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * <p>
 * 输入描述:
 * 输入一个整数（int类型）
 * <p>
 * 输出描述:
 * 这个数转换成2进制后，输出1的个数
 */
public class BinaryNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] charArray = Integer.toBinaryString(n).toCharArray();
        System.out.println(Arrays.toString(charArray));
        int count = 0;
        for (char c : charArray) {

            if (c == '1') {
                count++;
            }
        }
        System.out.println(count);
    }
}
