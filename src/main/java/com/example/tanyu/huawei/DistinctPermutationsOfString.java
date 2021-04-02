package com.example.tanyu.huawei;

import java.util.ArrayList;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/4/29 21:13
 */
public class DistinctPermutationsOfString {

    private static boolean isPresent(String s, ArrayList<String> Res) {

        for (String str : Res) {

            if (str.equals(s))
                return true;
        }

        return false;
    }

    private static ArrayList<String> distinctPermute(String str) {

        // 如果字符串为空
        if (str.length() == 0) {

            // 返回空字符串
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }

        // 取字符串的第一个字符
        char ch = str.charAt(0);

        // 取从下标[1...end]的字符串
        String restStr = str.substring(1);

        // 递归调用
        ArrayList<String> prevRes = distinctPermute(restStr);

        // 将生成的字符串排列加入到  Arraylist中
        ArrayList<String> Res = new ArrayList<>();
        for (String s : prevRes) {
            for (int i = 0; i <= s.length(); i++) {
                String f = s.substring(0, i) + ch + s.substring(i);

                // 如果新产生的字符串组合在当前的 Arraylist中不存在
                if (!isPresent(f, Res))
                    // 向Arraylist中添加字符串
                    Res.add(f);
            }
        }

        // 返回ArrayList
        return Res;
    }

    public static void main(String[] args) {
        String s = "abbb";
        System.out.println(distinctPermute(s));
    }
}

