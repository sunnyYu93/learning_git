package com.example.tanyu.algorithm.middle;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/17 23:07
 */
public class 回文子串 {
    public static int countSubstrings(String s) {
        int N = s.length();
        int ans = 0;
        for (int i = 0; i <= 2 * N - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int res = countSubstrings("abccba");
        System.out.println(res);
    }
}
