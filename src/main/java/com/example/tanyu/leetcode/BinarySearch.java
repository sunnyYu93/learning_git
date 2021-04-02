package com.example.tanyu.leetcode;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/5/31 10:47
 */
public class BinarySearch {
    /**
     * 寻找左侧边界
     *
     * @param nums
     * @param target
     * @return
     */
    static int leftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (left == nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }

    /**
     * 左侧边界左闭右闭区间
     */
    int leftBorderClosed(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - 1) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (left > nums.length || nums[left] != target) {
            return -1;
        }

        return left;
    }

    /**
     * 右侧边界搜索
     *
     * @param nums
     * @param target
     * @return
     */
    static int rightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    /**
     * 左侧边界"左闭右闭"区间
     */
    int rightBorderClosed(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return right;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 4};
        int i = leftBorder(arr, 2);
        System.out.println(i);

        int rightBorder = rightBorder(arr, 2);
        System.out.println(rightBorder);
    }
}
