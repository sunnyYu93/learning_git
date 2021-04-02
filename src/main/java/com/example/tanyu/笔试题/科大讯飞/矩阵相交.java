package com.example.tanyu.笔试题.科大讯飞;

import java.util.Scanner;

public class 矩阵相交 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xa1 = sc.nextInt();
        int ya1 = sc.nextInt();
        int xa2 = sc.nextInt();
        int ya2 = sc.nextInt();

        int xb1 = sc.nextInt();
        int yb1 = sc.nextInt();
        int xb2 = sc.nextInt();
        int yb2 = sc.nextInt();

        int res = Math.min(xa1, xb2) >= Math.max(xa1,xb1) && Math.min(ya2, yb2) >= Math.max(ya1,yb1)? 1 : 0;

        System.out.println(res);



}
}
