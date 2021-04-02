package com.example.tanyu.leetcode.字符串;

import java.util.Arrays;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/13 22:52
 */
public class 翻转单词顺序 {
    public static String reverseWords(String s) {
//        if(s==null || s.length()==0) {
//            return "";
//        }
//        String[] s1 = s.split(" ");
//        String res = "";
//        for (int i = s1.length-1; i >=0; i--) {
//            if (s1[i].length() != 0) {
//                res = res + s1[i] + " ";
//            }
//
//        }
//        return res.substring(0,res.length()-1);

        // 删除首尾空格
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--; // 搜索首个空格
            }
            // 添加单词
            res.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                // 跳过单词间空格
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));

    }
}
