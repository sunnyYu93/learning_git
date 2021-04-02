package com.example.tanyu.leetcode.array.easy;

import java.util.HashSet;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/28 20:39
 */
public class 判定字符是否唯一 {
    public boolean isUnique(String astr) {
        if (astr == null ||astr.length()==0) {
            return true;
        }
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            if (hashSet.contains(astr.charAt(i))) {
                return false;
            } else {
                hashSet.add(astr.charAt(i));
            }
        }

        return true;

    }
}
