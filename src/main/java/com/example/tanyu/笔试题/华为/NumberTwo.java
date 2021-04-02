package com.example.tanyu.笔试题.华为;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberTwo {

    public List<Integer> findMethod(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        int wordsNumber = words.length;
        int wordLength = words[0].length();
        HashMap<String, Integer> hashMap1 = new HashMap<>();

        for (int i = 0; i < wordsNumber; i++) {
            hashMap1.put(words[i], hashMap1.getOrDefault(words[i], 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            HashMap<String, Integer> hashMap2 = new HashMap<>();
            int num = 0;
            while (num < wordsNumber) {
                String word = s.substring(i + num * wordLength, i + (num + 1) * wordLength);
                if (hashMap1.containsKey(word)) {
                    int value = hashMap2.getOrDefault(word, 0);
                    hashMap2.put(word, value + 1);
                    if (hashMap2.get(word)>hashMap1.get(word)) {
                        break;
                    }
                } else {
                    break;
                }

                num++;
            }
        }

        return res;

    }
}
