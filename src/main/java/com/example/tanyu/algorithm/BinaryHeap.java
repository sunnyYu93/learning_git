package com.example.tanyu.algorithm;

import java.util.Arrays;

public class BinaryHeap {
    /**
     * 构建二叉堆
     */
    public static void buildHeap(int[] array) {
        //从最后一个非叶子节点开始，依次做“下沉”调整
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
    }

    /**
     * 下沉调整
     *
     * @param array       待调整的堆
     * @param parentIndex 要“下沉”的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点的值，用于最后的赋值操作
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果右孩子节点存在，并且右节点的值小于左节点的值，则定位到右节点再与父节点交换
            if (childIndex + 1 < length && array[childIndex] > array[childIndex + 1]) {
                childIndex++;
            }
            //如果父节点小于任何一个子节点的值，则直接跳出
            if (temp <= array[childIndex]) {
                break;
            }

            //交换父节点与子节点的值，子节点上浮到父节点位置
            array[parentIndex] = array[childIndex];
            // 父节点需要下沉的位置为：子节点之前的位置
            parentIndex = childIndex;
            // 这么计算的原因：判断该位置下是否还有子节点，如果有的话还是要继续下沉操作
            childIndex = 2 * childIndex + 1;

        }
        //将父节点值“下沉”到子节点的位置
        array[parentIndex] = temp;
    }

    /**
     * "上浮"调整
     *
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        // temp用于保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        // 此节点不在顶点，且它的值比父节点小时才进行下沉操作
        while (childIndex > 0 && temp < array[parentIndex]) {

            // 父节点值下沉到子节点位置
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        // 子节点上浮到父节点位置
        array[childIndex] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};

        upAdjust(array);
        System.out.println(Arrays.toString(array));

//        array = new int[] {7,1,3,10,5,2,8,9,6};
//        buildHeap(array);
//        System.out.println(Arrays.toString(array));
    }

}
