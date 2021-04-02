package com.example.tanyu.test;

/**
 * 测试try、catch、finally的执行顺序
 * 结果为try->finally->catch
 */
public class TestTryFinally {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("try处");
            int a = 1 / 0;
        } catch (Exception e) {
            throw new Exception("catch处");
        } finally {
            System.out.println("finally处");
        }
        ;
    }
}
