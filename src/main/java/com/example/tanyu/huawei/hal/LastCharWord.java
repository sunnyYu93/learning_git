package com.example.tanyu.huawei.hal;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;

@Slf4j
public class LastCharWord {

    /**
     * 最后一个字符的长度
     * 这种方式只是将字符串的末尾的空格消除掉。首部、中间的空格不消除
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        System.out.println(Arrays.toString(arr));
        log.info("长度:{}", arr.length);
        int length = arr[arr.length - 1].length();
        System.out.println(length);

    }
}

