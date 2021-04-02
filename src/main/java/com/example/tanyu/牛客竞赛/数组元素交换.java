package com.example.tanyu.牛客竞赛;

import java.util.Arrays;
import java.util.HashMap;

public class 数组元素交换 {
    /**
     * @param a int整型一维数组 原始数组a
     * @param n int整型 第n大
     * @param m int整型 第m大
     * @return int整型一维数组
     */
    public static int[] sovle(int[] a, int n, int m) {
        // write code here

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            hashMap.put(a[i], i);
        }

        int[] copyArr = Arrays.copyOf(a, a.length);
        Arrays.sort(copyArr);
        int k = copyArr[n - 1];
        int l = copyArr[m - 1];
        int temp = a[hashMap.get(k)];
        a[hashMap.get(k)] = a[hashMap.get(l)];
        a[hashMap.get(l)] = temp;

        return a;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        System.out.println(Arrays.toString(sovle(arr, 1, 2)));
    }
}
