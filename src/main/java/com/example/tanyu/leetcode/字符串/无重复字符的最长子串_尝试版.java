package com.example.tanyu.leetcode.字符串;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串_尝试版 {
    /**
     * 第一遍的思路，双指针检索。
     * 但是需要一个set记录已经遍历过得字符集。当不满足的时候需要清空set
     * 或者利用数组记录对应字符的索引是否有值，但也要面临记录清楚的操作
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 1;
        }
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int len = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {

                left = right;
                set.clear();
            }
            len = Math.max(len, right - left);

        }

        return len;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("au");
    }
}
