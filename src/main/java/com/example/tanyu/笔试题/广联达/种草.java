package com.example.tanyu.笔试题.广联达;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 种草 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        System.out.println(n);
        System.out.println(m);
        System.out.println(x);
        int[] arr = new int[n];
        int index = 0;
        while (scanner.hasNextInt()) {
            arr[index++] = scanner.nextInt();
            System.out.println(Arrays.toString(arr));
        }

        for (int i = 0; i < m; i++) {
            Arrays.sort(arr);
            arr[0] = arr[0] + x;
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}

class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            queue.add(queue.poll() + x);
        }

        System.out.println(queue.peek());
    }
}
