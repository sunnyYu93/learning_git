package com.example.tanyu.huawei;


/**
 * @author tanyu
 * @version 1.0
 * @date 2020/4/29 19:27
 */
public class NumberTwo {
    public static void main(String[] args){
        NumberTwo demo=new NumberTwo();
        String string="asdafxcvMADb";
        demo.sortByASCII(string);

    }

    public void sortByASCII(String str){
        char []array=str.toCharArray();   //将一个简单的字符串中的内容转化为char数组
        sort(array);
        for(char s:array)          //输出
            System.out.print(s);
    }

    public static void sort(char []arr){
        char []temp = new char[arr.length];    //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(char[] arr,int left,int right,char []temp){
        if(left<right){
            int mid = (left+right)/2;
            //递归的方法
            sort(arr,left,mid,temp);        //左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(char[] arr,int left,int mid,int right,char[] temp){
        int i = left;          //左序列指针
        int j = mid+1;        //右序列指针
        int t = 0;           //临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j])
                temp[t++] = arr[i++];
            else
                temp[t++] = arr[j++];
        }
        while(i<=mid){               //将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){            //将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}
