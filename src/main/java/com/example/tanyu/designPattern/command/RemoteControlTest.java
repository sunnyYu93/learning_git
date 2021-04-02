package com.example.tanyu.designPattern.command;

import java.util.ArrayList;
import java.util.List;


/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/27 9:09
 */
public class RemoteControlTest {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        System.out.println(list.size());
//        System.out.println(list.toString());
////        Iterator<String> iterator = list.iterator();
////        while (iterator.hasNext()) {
////            String item = iterator.next();
////            if (item.equals("1")) {
////                iterator.remove();
////            }
////        }
////
////        System.out.println(list.size());
//        synchronized (new Object()) {
//            for (String item : list) {
//                if ("2".equals(item)) {
//                    list.remove(item);
//                }
//            }
//        }
//
//        System.out.println(list.toString());
//        System.out.println(list.size());


        int[] arr = new int[]{2, 823, 7, 9999};

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        int k = 0;
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
                k = i;
            }
            list.add(false);
        }
        if (extraCandies == 1) {
            list.set(k, true);
            return list;
        }

        for (int j = 0; j < candies.length; j++) {
            if ((candies[j] + extraCandies) >= max) {
                list.set(j, true);
            }
        }

        String s = String.valueOf(809);
        int length = s.length();
        if ((5 & 1) == 0) {
            return list;
        }
        return list;


    }


}

