package com.example.tanyu.leetcode.字符串;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/6/4 22:07
 */
public class 无重复字符的最长子串 {
    /**
     * 双指针移动，形成一个窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int[] counts = new int[256];
        int maxLen = 0;
        int i = 0;
        int j = 0;
        for (; i < s.length(); i++) {
            for (; j < s.length(); j++) {
                char c = s.charAt(j);
                if (counts[c] != 0) {
                    break;
                } else {
                    counts[s.charAt(j)] += 1;
                }
            }
            maxLen = Math.max(maxLen, j - i);
            counts[s.charAt(i)] -= 1;
        }

        return maxLen;
    }

    /**
     * 此方法优化i的重复位置，跳过重复位置
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int maxLen = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            //如果j位置的字符已经出现过，则将i指向出现的位置右边一位
            i = Math.max(index[s.charAt(j)] + 1, i);
            maxLen = Math.max(maxLen, j - i + 1);
            //保存j指向的字符及下标
            index[s.charAt(j)] = j;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String a = "abcda";
        lengthOfLongestSubstring1(a);
        System.out.println((int) a.charAt(0));
    }
}
