package com.example.tanyu.leetcode.字符串.滑动窗口;

import java.util.HashMap;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/10 23:29
 */
public class 字符串的排列 {
    public static boolean checkInclusion(String s1, String s2) {
        //保存 t 中的字符串，用于查找
        HashMap<Character, Integer> need = new HashMap<>();
        // 窗口中找到的字符对应的个数
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        System.out.println(need);
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            //窗口内数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断是否需要收缩左边窗口
            // 移动 left 缩⼩窗⼝的时机是窗⼝⼤⼩⼤于 s1.size() 时，因为排列嘛，显然⻓度应该是⼀样的。
            while (right - left >= s1.length()) {
                // 排列是连续的，valid==need.size()时就是要找的排列
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                // 满足条件的话，移出字符d
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));

    }


}
