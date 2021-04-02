package com.example.tanyu.leetcode.字符串;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/21 20:37
 */
public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
            if (arr[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "adsf";
        System.out.println(s.charAt(0) - 0);
    }
}
