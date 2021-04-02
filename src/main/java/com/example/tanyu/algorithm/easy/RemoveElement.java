package com.example.tanyu.algorithm.easy;

import java.util.ArrayList;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/4/26 9:17
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    private static int removeElementTwo(int[] nums, int val) {
        int i=0;
        int n=nums.length;
        while (i<n) {
            if (nums[i]==val) {
                nums[i] = nums[n-1];
                n--;
            } else {
                i++;
            }

        }

        return n;
    }

    public static void main(String[] args) {
        int[] nums =new int[]{1,3,4,6,1};
        int val=1;


//        removeElement(nums,val);
        removeElementTwo(nums,val);
    }
}
