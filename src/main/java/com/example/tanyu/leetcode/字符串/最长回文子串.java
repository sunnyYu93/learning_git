package com.example.tanyu.leetcode.字符串;

public class 最长回文子串 {
    /**
     * 暴力解法
     */
    static class Solution {

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
            char[] charArray = s.toCharArray();
            // 枚举所有长度大于 1 的子串 charArray[i..j]
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }

        /**
         * 验证子串 s[left..right] 是否为回文串
         */
        private boolean validPalindromic(char[] charArray, int left, int right) {
            while (left < right) {
                if (charArray[left] != charArray[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        /**
         * 中心扩展法
         */
        public String longestPalindrome2(String s) {

            if (s == null || s.length() == 0) {
                return "";
            }

            int start = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                //以i为中心的一个字母为中心向两边扩展
                int len1 = expandAroundCenter(s, i, i);
                //以i、i+1为中心的两个字母为中心向两边扩展
                int len2 = expandAroundCenter(s, i, i + 1);
                int maxLen = Math.max(len1, len2);

                if (maxLen > end - start) {
                    start = i - (maxLen - 1) / 2;
                    end = i + maxLen / 2;
                }
            }

            return s.substring(start, end + 1);
        }

        /**
         * 中心扩张法计算字符串的长度
         *
         * @param s
         * @param left
         * @param right
         * @return
         */
        public int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            return right - left - 1;
        }
    }
}
