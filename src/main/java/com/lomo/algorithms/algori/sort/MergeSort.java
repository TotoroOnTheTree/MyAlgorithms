package com.lomo.algorithms.algori.sort;

/**
 *  第一次靠自己实现的归并排序 .
 *  有一些缺点：
 *      1. 创建了多个数组对象
 *      2. 合并不够优雅
 * @Author: xumao
 * @DateTime: 2020/5/14 11:07
 * @Version: 1.0
 **/
public class MergeSort implements Sort{




    @Override
    public void sort(Integer[] datas) {
        Integer[] d = partitionAndMerge(datas, 0, datas.length - 1);
        for (int i = 0; i < d.length; i++) {
            datas[i] = d[i];
        }
    }

    /*分区与合并*/
    private static Integer[] partitionAndMerge(Integer[] datas,int begin,int end){
        if(begin == end){
            return new Integer[]{datas[begin]};
        }
        //1.取中位
        int mid = (begin + end)/2;
        //2. 分治
        Integer[] left = partitionAndMerge(datas, begin, mid);
        Integer[] right = partitionAndMerge(datas, mid + 1, end);
        Integer[] merge = merge(left, right);
        return merge;
    }

    private static Integer[] merge(Integer[] left, Integer[] right){
        int a1 = 0;//指向left的指针
        int a2 = 0;//指向right的指针
        Integer[] tmp = new Integer[left.length+right.length];
        int k = 0;

        while (a1<left.length && a2< right.length){
            if(left[a1] > right[a2]){
                tmp[k++] = right[a2];
                a2++;
            }else {
                tmp[k++]= left[a1];
                a1++;
            }
        }

        if(a1<left.length){//将还要剩余的数据拷出来
            for (int i = a1; i < left.length; i++) {
                tmp[k++] = left[i];
            }
        }
        if(a2<right.length){//将还要剩余的数据拷出来
            for (int i = a2; i < right.length; i++) {
                tmp[k++] = right[i];
            }
        }
        return tmp;
    }

}
