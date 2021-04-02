package com.example.tanyu.leetcode.回溯;

import java.util.*;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/3 20:41
 */
public class 电话号码的字母组合 {
    private final String[] mapping = new String[]{"abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits==null || digits.length()==0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        combinations(digits,0,"",result);
        return result;
    }

    public void combinations(String digits, int index, String str, List<String> result) {
        if (index==digits.length()) {
            result.add(str);
            return;
        }

        String chars = mapping[digits.charAt(index)-'2'];
        for (int i = 0; i < chars.length(); i++) {
            combinations(digits, index+1, str+chars.charAt(i), result);
        }
    }
}

