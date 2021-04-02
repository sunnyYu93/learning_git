package com.example.tanyu.huawei.hal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArgumentParsing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] charArray = string.toCharArray();
        List<String> list = new ArrayList<>();
        String temp = "";
        //引号标志位
        boolean isQuotes = false;
        for (int i = 0; i < charArray.length; i++) {
            //判断左引号
            if (charArray[i] == '\"' && !isQuotes) {
                isQuotes = true;
                continue;
            }

            //判断右双引号
            if (charArray[i] == '\"' && isQuotes) {
                isQuotes = false;
                continue;
            }

            //判断引号间的空格
            if (charArray[i] == ' ' && isQuotes) {
                temp += charArray[i];
                continue;
            }

            //
            if (charArray[i] == ' ') {
                list.add(temp);
                temp = "";
                continue;
            }

            temp += charArray[i];

        }
        list.add(temp);

        System.out.println(list.size());

        for (String s : list) {
            System.out.println(s);
        }


    }
}




