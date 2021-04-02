package com.example.tanyu.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/26 19:35
 */
public class 字母大小写全排列 {

    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        char[] chars = new char[S.length()];
        dfs(S, 0, chars);
        return res;
    }

    /**
     * 递归方法
     */
    public void dfs(String S, int index, char[] charArr) {
        if (index == S.length()) {
            res.add(new String(charArr));
            return;
        }

        charArr[index] = S.charAt(index);
        dfs(S, index + 1, charArr);

        // 如果是字符的话，派生出另外一个分支
        if (Character.isLetter(S.charAt(index))) {
            // 将字母转换成对应的大小写，相当于回溯了
            charArr[index] = (char)(S.charAt(index) ^ (1 << 5));
            dfs(S, index+1, charArr);
        }

    }

}
