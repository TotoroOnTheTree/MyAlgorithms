package com.lomo.algorithms.video.lesson1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 假定一个排序数组以某个未知元素为支点做了旋转，
 * 如：原数组 `0 1 2 4 5 6 7`旋转后得到`4 5 6 7 0 1 2`。
 * 请找出旋转后数组中的最小元素。假定数组中没有重复数字。
 */
public class MinElementAfterRotated {

    Integer[] origin = new Integer[]{4,5,6,7,0,1,2};


    /**
     * 暴力法
     */
    @Test
    void cycle(){
        Integer min = 0;
        for (Integer el: origin){
            if(el<min){
                min = el;
            }
        }
        System.out.println("最小元素："+min);
    }


    /**
     * 二分法
     */
    @Test
    void  halfMehtodTest(){
        List<Integer[]> list = new ArrayList<Integer[]>();
        list.add(new Integer[]{4,6,7,10,12,17,19,0,2,3});
        list.add(new Integer[]{18,15,13,9,4,3,2,0,101,89,32,23});
        list.add(new Integer[]{18,15,13,9,4,4,2,2,1,101,89,32,23});
        for (Integer[] arr : list){
            Integer num = halfSearch(arr);
            System.out.printf("最小元素为：%d\n",num);
        }
    }

    private boolean bigerThanTail(Integer[] origin){
        int first = 0;
        int last = origin.length-1;
        if(origin[first]>origin[last]){
            return true;
        }
        if (origin[first]==origin[last]){
            //比较下一个字符
            for (int i=first+1; i<last; i++){
                if(origin[i]>origin[last]){
                    return true;
                }
            }
        }
        return false;
    }
    private int halfSearch(Integer[] origin){
        Integer head = 0;
        Integer tail = origin.length-1;
        Integer mid ;
        if(bigerThanTail(origin)){//origin旋转前为升序
            while (head<tail){
                mid = (head+tail)/2;
                if(origin[mid]<origin[tail]){//在前半段
                    tail = mid;
                }
                else if(origin[mid]>origin[tail]){//在后半段
                    head = mid+1;
                }
            }
            return origin[head];
        }
        else {//origin旋转前为降序
            while (head<tail){
                mid = (head+tail)/2;
                if(origin[mid]>origin[tail]){//在前半段
                    tail = mid;
                }
                else if(origin[mid]<origin[tail]){//在后半段
                    head = mid+1;
                }
            }
            return origin[head-1];//降序的结束条件会多走1
        }
    }


}
