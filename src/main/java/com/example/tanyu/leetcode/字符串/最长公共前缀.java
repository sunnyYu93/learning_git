package com.example.tanyu.leetcode.字符串;

public class 最长公共前缀 {

    /**
     * 横向比较
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs.length;
        String profix = strs[0];
        for (int i = 1; i < len; i++) {
            profix = longestCommonProfixOfTwoString(profix, strs[i]);
            // 如果公共前缀是“”，则后面的循环就不用进行了，进行了也是空串
            if (profix.length()==0) {
                break;
            }
        }

        return profix;
    }


    /**
     * 寻找两个字符串的公共前缀
     * @param s1
     * @param s2
     * @return
     */
    public String longestCommonProfixOfTwoString(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        int index = 0;
        while (index < minLen && s1.charAt(index) == s2.charAt(index)) {
            index++;
        }

        return s1.substring(0, index);
    }

    /**
     * 纵向比较,比较每个字符串的相同位置是否相等，不一样则取该位置前的字符串为公共前缀
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < len; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];

    }
}
