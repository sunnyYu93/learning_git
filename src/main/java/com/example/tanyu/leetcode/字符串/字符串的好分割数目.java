package com.example.tanyu.leetcode.字符串;

import java.util.HashSet;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/25 23:05
 */
public class 字符串的好分割数目 {
    public int numSplits(String s) {
        HashSet<Character> leftHashSet = new HashSet<>();
        HashSet<Character> rightHashSet = new HashSet<>();
        int index = 1;
        int sum = 0;
        while (index < s.length()) {
//            for (int i = 0; i < index; i++) {
//                if (!leftHashSet.contains(s.charAt(i))) {
//                    leftHashSet.add(s.charAt(i));
//                }
//            }

            if (!leftHashSet.contains(s.charAt(index))) {
                leftHashSet.add(s.charAt(index));
            }

            for (int i = index; i < s.length(); i++) {
                if (!rightHashSet.contains(s.charAt(i))) {
                    rightHashSet.add(s.charAt(i));
                }
            }

            if (rightHashSet.size() == leftHashSet.size()) {
                sum++;
            }
            index++;
            rightHashSet.clear();
        }

        return sum;


    }
}
