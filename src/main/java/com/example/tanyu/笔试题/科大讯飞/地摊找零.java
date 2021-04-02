package com.example.tanyu.笔试题.科大讯飞;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 地摊找零 {

    static int num = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];
        int[] money = new int[]{1, 5, 10, 50, 100};
        for (int i = 0; i < 5; i++) {
            array[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, array[0]);
        hashMap.put(5, array[1]);
        hashMap.put(10, array[2]);
        hashMap.put(50, array[3]);
        hashMap.put(100, array[4]);

        int k = sc.nextInt();

        int[] dp = new int[k + 1];
        Arrays.fill(dp, k + 1);
        dp[0] = 0;
        for (int coin : money) {
            for (int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
            hashMap.put(coin, hashMap.getOrDefault(coin,0)-1);
            if (hashMap.get(coin) == 0) {
                continue;
            }
        }

        if (dp[k] == k + 1) {
            dp[k] = -1;
        }

        System.out.println(dp[k]);
    }


}
