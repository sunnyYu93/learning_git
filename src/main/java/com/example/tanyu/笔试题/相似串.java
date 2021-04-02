package com.example.tanyu.笔试题;

import java.util.HashMap;
import java.util.Scanner;

public class 相似串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(findRealStr(s));
        scanner.close();

    }

    public static String findRealStr(String str) {
        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (map.get(temp) == null) {
                map.put(temp, c++);
            }
            sb.append(map.get(temp));
        }

        return sb.toString();
    }
}
