package com.lomo.algorithms.algori.sort;

/**
 * 插入排序 .
 *
 * @Author: xumao
 * @DateTime: 2020/5/14 11:17
 * @Version: 1.0
 **/
public class InsertSort implements Sort{

    @Override
    public void sort(Integer[] datas) {
        if(datas.length<=1){
            return ;
        }
        for (int i = 1; i < datas.length; i++) {//1. i从1取
            int value = datas[i];
            int j = i-1;//j来存要插入数据的下标
            for (; j >=0 ; j--) {
                if(datas[j]>value){
                    datas[j+1] = datas[j];//3.比value大的，都往后移动
                }else {
                    break;
                }
            }
            datas[j+1] = value;//4.上面循环结束时会多-1
        }
    }
}
