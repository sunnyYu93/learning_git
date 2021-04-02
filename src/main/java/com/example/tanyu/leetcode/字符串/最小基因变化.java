package com.example.tanyu.leetcode.字符串;

import java.util.*;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/6 19:52
 *
 * 思路：
 * 从基因库中查看与当前字符串差一个字符的字符串
 * 可能存在这样的情况，一个字符串已经被访问但是基因库中没有和当前字符串相差1的字符串
 * 这并不代表基因库中的这个字符串作废，仅仅是针对当前情况失效， 我们必须从已访问中移除，
 * 他很可能就是最后和end差1个字符的字符串也未可能
 *
 */
public class 最小基因变化 {
    int count = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> vistied = new HashSet<>();
        dfs(0, start, end, bank, vistied);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    private void dfs(int minStepCount, String start, String end, String[] bank, HashSet<String> vistied) {
        if (start.equals(end)) {
            count = Math.min(count, minStepCount);
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            int diff = 0;
            for (int j = 0; j < 8; j++) {
                if (bank[i].charAt(j) != start.charAt(j)) {
                    diff++;
                }
                if (diff > 1) {
                    break;
                }
            }
            if (diff == 1 && !vistied.contains(bank[i])) {
                vistied.add(bank[i]);
                dfs(minStepCount + 1, bank[i], end, bank, vistied);
                vistied.remove(bank[i]);
            }
        }
    }

}
