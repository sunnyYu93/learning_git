package com.example.tanyu.leetcode.数学;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/6 19:33
 */
public class 计算x的n次幂函数 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        // 当 n = -2147483648n=−2147483648 时执行 n = -n
        // 会因越界而赋值出错。解决方法是先将 nn 存入 long 变量 b，后面用 b 操作即可
        long b = (long) n;
        double res = 1.0;

        while (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
