package com.example.tanyu.leetcode.array.easy;

public class 删除排序数组中的重复项II {
    public int[] remElement(int[] arr, int index) {

        //
        // Overwrite the element at the given index by
        // moving all the elements to the right of the
        // index, one position to the left.
        //
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        return arr;
    }

    public int removeDuplicates(int[] nums) {

        // Initialize the counter and the array index.
        int i = 1;
        int count = 1;
        int length = nums.length;
        // 区间为前闭后开[i,length)
        while (i < length) {

            // 如果数组中元素相邻且相等，增加计算count
            if (nums[i] == nums[i - 1]) {
                count++;

                // 如果连续相等元素个数大于2，移除i位置的元素
                if (count > 2) {
                    this.remElement(nums, i);
                    // i--后重新在count=2的位置开始计算下一个位置是否还是同样的重复元素
                    i--;

                    //i位置后的元素全部向前移动一位，故真实的数组长度需要减一
                    length--;
                }
            } else {
                //遇到下一个元素，故count重置为1
                count = 1;
            }
            i++;
        }

        return length;
    }


    /**
     * 双指针
     * @param nums
     * @return
     *
     * 画图吧，不然看不懂
     */
    public int removeDuplicates2(int[] nums) {


        int j = 1;
        //初始化计数为1
        int count = 1;
        // 从数组第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                // nums[i] != nums[i - 1],遇到不同的元素，将count重置为1
                count = 1;
            }

            //将位置i的移动到j位置。
            if (count <= 2) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
