package com.example.tanyu.leetcode.字符串.滑动窗口;

import java.util.HashMap;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/10 21:27
 */
public class 最小覆盖子串 {
    public static String minWindow(String s, String t) {
        //保存 t 中的字符串，用于查找
        HashMap<Character, Integer> need = new HashMap<>();
        // 窗口中找到的字符对应的个数
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        System.out.println(need);
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 窗口内数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断是否需要收缩左边窗口
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // d是需要移出窗口的字符
                char d = s.charAt(left);
                //收缩窗口
                left++;
                // 进行窗口内数据更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        System.out.println("start:" + start + ", len" + len);

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("BBCDADBC", "ABC"));
    }
}
