package com.example.tanyu.笔试题.广联达;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 作者：无情的offer收割机
 * 链接：https://www.nowcoder.com/discuss/462492?type=post&order=create&pos=&page=0&channel=2000&source_id=search_post
 * 来源：牛客网
 * <p>
 * 我们希望一个序列中的元素是各不相同的，但是理想和现实往往是有差距的。现在给出一个序列A，
 * 其中难免有些相同的元素，现在提供了一种变化方式，使得经过若干次操作后一定可以得到一个元素各不相同的序列。
 * 这个操作是这样的，令x为序列中最小的有重复的数字，你需要删除序列左数第一个x，并把第二个x替换为2*x。
 * 请你输出最终的序列。
 * 例如原序列是[2,2,1,1,1],一次变换后变为[2,2,2,1]，两次变换后变为[4,2,1]，变换结束。
 */

public class 各不相同 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        int[] arr = new int[i];
//        int index = 0;
//        while (scanner.hasNextInt()) {
//            arr[index++] = scanner.nextInt();
//            System.out.println(Arrays.toString(arr));
//        }
//        int left = arr.length-1;
//        int right = arr.length-1;
//        while (left>=0) {
//            while (arr[left] == arr[right]) {
//                left--;
//            }
//
//        }

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (long i = 0; i < n; i++) {
            queue.add(sc.nextLong());
        }

        Stack<Long> stack = new Stack<>();
        while (!queue.isEmpty()) {
            long tmp = queue.poll();
            if (queue.isEmpty()) {
                stack.push(tmp);
                continue;
            }

            if (tmp != queue.peek()) {
                stack.push(tmp);
            } else {
                queue.add(queue.poll() * 2);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
