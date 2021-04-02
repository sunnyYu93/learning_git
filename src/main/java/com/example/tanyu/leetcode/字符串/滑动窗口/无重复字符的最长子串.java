package com.example.tanyu.leetcode.字符串.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/11 10:41
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        // 子串最大长度
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 更新窗口内数据，将重复字符移出窗口
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
