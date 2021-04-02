package com.example.tanyu.leetcode.字符串.滑动窗口;

import java.net.URL;
import java.util.*;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/11 10:09
 */
public class 找到字符串中所有字母异位词 {
    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;

        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }

            }

            //判断是否收缩左窗口
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    list.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        Collections.sort(new ArrayList<Integer>());
    }
}


