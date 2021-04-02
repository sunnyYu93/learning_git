package com.example.tanyu.笔试题.科大讯飞;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 字符串提取整数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String regEx= "[^0-9]";
        Pattern compile = Pattern.compile(regEx);
        Matcher matcher = compile.matcher(s);

        String trim = matcher.replaceAll("").trim();
        System.out.println(trim);


    }
}
