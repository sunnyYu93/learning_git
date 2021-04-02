package com.example.tanyu.algorithm;

import lombok.extern.slf4j.Slf4j;


import java.util.Arrays;


/**
 * 位移实现四则运算
 *
 * @author tanyu
 * @version 1.0
 * @date 2020/4/13 12:00
 */

@Slf4j
public class Arithmetic {

    /**
     * 递归实现加法运算
     *
     * @param num1
     * @param num2
     * @return
     */
    static int addByRecursion(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return addByRecursion(num1 ^ num2, (num1 & num2) << 1);
        }
    }

    /**
     * 迭代实现加法运算
     *
     * @param num1
     * @param num2
     * @return
     */
    static int addByIteration(int num1, int num2) {
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        while (carry != 0) {
            int a = sum;
            int b = carry;
            sum = a ^ b;
            carry = (a & b) << 1;
        }
        return sum;

    }

    /**
     * 减法运算
     * 5-4可以转换成计算5+(-4)
     *
     * @param num1
     * @param num2
     * @return
     */
    static int substract(int num1, int num2) {
        int substractor = addByIteration(~num2, 1);
        return addByIteration(num1, substractor);

    }

    /**
     * 乘法运算
     *
     * @param a
     * @param b
     * @return 1、取绝对值
     * 2、计算绝对值的乘积，累加计算
     * 3、确定乘积的符号
     */
    private static int multiply(int a, int b) {
        // 取绝对值　　
        int multiplicand = a < 0 ? addByIteration(~a, 1) : a;
        int multiplier = b < 0 ? addByIteration(~b, 1) : b;// 如果为负则取反加一得其补码，即正数　　
        // 计算绝对值的乘积　　
        int product = 0;
        int count = 0;
        while (count < multiplier) {
            product = addByIteration(product, multiplicand);
            count = addByIteration(count, 1);// 这里可别用count++，都说了这里是位运算实现加法　　
        }
        // 确定乘积的符号　　
        if ((a ^ b) < 0) {// 只考虑最高位，如果a,b异号，则异或后最高位为1；如果同号，则异或后最高位为0；　　　　
            product = addByIteration(~product, 1);
        }
        return product;

    }

    /**
     * 第二种方式乘法运算
     *
     * @param a
     * @param b
     * @return
     */
    static int multiplySecond(int a, int b) {
        //将乘数和被乘数都取绝对值　
        int multiplicand = a < 0 ? addByIteration(~a, 1) : a;
        int multiplier = b < 0 ? addByIteration(~b, 1) : b;
        int product = 0;
        while (multiplier > 0) {
            if ((multiplier & 0x1) > 0) {
                product = addByIteration(product, multiplicand);
            }
            multiplicand = multiplicand << 1;
            multiplier = multiplier >> 1;
        }

        if ((a ^ b) < 0) {
            product = addByIteration(~product, 1);
        }

        return product;
    }

    /**
     * a : 被除数
     * b : 除数
     */
    private static int divide(int a, int b) {
        // 先取被除数和除数的绝对值
        int dividend = a > 0 ? a : addByIteration(~a, 1);
        int divisor = b > 0 ? b : addByIteration(~b, 1);

        log.info("divisor:{}", divisor);
        log.info("dividend:{}", dividend);
        int quotient = 0;// 商
        int remainder = 0;// 余数
        // 不断用除数去减被除数，直到被除数小于被除数（即除不尽了）
        while (dividend >= divisor) {// 直到商小于被除数
            dividend = substract(dividend, divisor);
            quotient = addByIteration(quotient, 1);

        }
        // 确定商的符号
        if ((a ^ b) < 0) {// 如果除数和被除数异号，则商为负数
            quotient = addByIteration(~quotient, 1);
        }
        // 确定余数符号
        remainder = b > 0 ? dividend : addByIteration(~remainder, 1);
        return quotient;// 返回商
    }


    /**
     * 第二种减法方式
     *
     * @param a
     * @param b
     * @return
     */
    private static int[] divide_v2(int a, int b) {
        // 先取被除数和除数的绝对值
        int dividend = a > 0 ? a : addByIteration(~a, 1);
        int divisor = b > 0 ? b : addByIteration(~b, 1);
        int quotient = 0;// 商
        int remainder = 0;// 余数
        for (int i = 31; i >= 0; i--) {
            //比较dividend是否大于divisor的(1<<i)次方，不要将dividend与(divisor<<i)比较，而是用(dividend>>i)与divisor比较，
            //效果一样，但是可以避免因(divisor<<i)操作可能导致的溢出，如果溢出则会可能dividend本身小于divisor，但是溢出导致dividend大于divisor
            if ((dividend >> i) >= divisor) {
                quotient = addByIteration(quotient, 1 << i);
                dividend = substract(dividend, divisor << i);
            }
        }
        // 确定商的符号
        if ((a ^ b) < 0) {
            // 如果除数和被除数异号，则商为负数
            quotient = addByIteration(~quotient, 1);
        }
        // 确定余数符号,余数的符号和被除数一样
        remainder = a > 0 ? dividend : addByIteration(~dividend, 1);

        return new int[]{quotient, remainder};// 返回商
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(divide_v2(27, -8)));

    }
}
