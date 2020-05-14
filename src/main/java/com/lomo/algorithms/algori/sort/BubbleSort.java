package com.lomo.algorithms.algori.sort;

/**
 * TODO .
 *
 * @Author: xumao
 * @DateTime: 2020/5/14 11:35
 * @Version: 1.0
 **/
public class BubbleSort implements Sort {

    @Override
    public void sort(Integer[] datas) {
        for (int i = 0; i < datas.length; i++) {
            Boolean exchange = false;//是否有交换
            for (int j = 0; j < datas.length-i-1 ; j++) {//注意这里，后面的已经交换的元素不用再去比较了
                if(datas[j]>datas[j+1]){
                    Integer a = datas[j];
                    datas[j] = datas[j+1];
                    datas[j+1] = a;
                    exchange = true;
                }
            }
            if(!exchange){//没交换了说明排序完了
                return ;
            }
        }
    }
}
