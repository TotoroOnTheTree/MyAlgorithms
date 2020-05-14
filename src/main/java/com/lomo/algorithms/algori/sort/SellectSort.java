package com.lomo.algorithms.algori.sort;

/**
 * 第一次实现的选择排序 .
 *
 * @Author: xumao
 * @DateTime: 2020/5/14 11:09
 * @Version: 1.0
 **/
public class SellectSort implements Sort{



    @Override
    public void sort(Integer[] datas) {
        for (int i = 0; i < datas.length; i++) {
            for (int j = i+1; j < datas.length ; j++) {
                if(datas[i]>datas[j]){
                    Integer c = datas[i];
                    datas[i] = datas[j];
                    datas[j] = c;
                }
            }
        }
    }
}
