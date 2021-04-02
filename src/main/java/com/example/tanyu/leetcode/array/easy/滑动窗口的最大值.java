package com.example.tanyu.leetcode.array.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/13 21:44
 */
public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length==0) {
            return new int[]{};
        }
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int[] res = new int[nums.length - k + 1];
        while (right < nums.length) {
            max = Math.max(max, nums[right]);
            right++;
            while (right - left >= k) {
                if (right - left == k) {
                    res[left] = max;
                    max = Integer.MIN_VALUE;
                    break;
                }
                left++;
                //left和right开始从同一点位置开始移动
                right = left;
            }
        }

        return res;
    }

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) {
            // 未形成窗口，保证窗口中的元素是最大的
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i = k; i < nums.length; i++) {
            // 形成窗口后，如果新元素=队首元素，删除队首（队首元素最大）
            if(deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            // 删除队列中小于新加入元素的值
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
