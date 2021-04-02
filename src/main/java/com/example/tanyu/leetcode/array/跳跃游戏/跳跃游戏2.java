package com.example.tanyu.leetcode.array.跳跃游戏;

public class 跳跃游戏2 {
    /**
     * 贪心算法，取自官方题解
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        //最后一个位置不跳，如果前面n-2个位置跳不到最后一个位置的话，
        // 那最后一个位置的跳跃动作也没有必要
        //在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，
        // 我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
        // 如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，
        // 因此我们不必访问最后一个元素。
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //到达边界
            if (i == end) {
                //更新边界，即下一次起跳的位置设置为本次贪心算法下能达到的最远的位置
                end = maxPosition;
                steps++;
            }
        }

        return steps;

    }
}
