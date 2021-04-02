package com.example.tanyu.集合;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tanyu
 * @version 1.0
 * @date 2020/7/3 10:57
 */
@Slf4j
public class ListDemo {
    public void testListToArray(){
        List<Integer> list = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        // 下面这行被注释的代码这么写是无法转化成数组的，无参 toArray 返回的是 Object[],
        // 无法向下转化成 List<Integer>，编译都无法通过
//         List<Integer> list2 = list.toArray();
        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));

        // 演示有参 toArray 方法，数组大小不够时，得到数组为 null 情况
        Integer[] array0 = new Integer[2];
        Integer[] toArray = list.toArray(array0);
        System.out.println(Arrays.toString(toArray));
        log.info("toArray 数组大小不够，array0 数组[0] 值是{},数组[1] 值是{},",array0[0],array0[1]);

        // 演示数组初始化大小正好，正好转化成数组
        Integer[] array1 = new Integer[list.size()];
        list.toArray(array1);
        log.info("toArray 数组大小正好，array1 数组[3] 值是{}",array1[3]);

        // 演示数组初始化大小大于实际所需大小，也可以转化成数组
        Integer[] array2 = new Integer[list.size()+2];
        list.toArray(array2);
        log.info("toArray 数组大小多了，array2 数组[3] 值是{}，数组[4] 值是{}",array2[3],array2[4]);
    }

    public static void main(String[] args) {
        new ListDemo().testListToArray();
    }
}
