package com.lomo.algorithms.algori.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortTest {


    @Test
    void bubbleSort() {
        Integer[] datas = {10,9,8,7,6,4,3,5,2,1};
        new BubbleSort().sort(datas);
        print(datas);
    }


    @Test
    void insertSort() {
        Integer[] datas = {10,9,8,7,6,4,3,5,2,1};
        new InsertSort().sort(datas);
        print(datas);
    }


    @Test
    void mergeSort() {
        Integer[] datas = {10,9,8,7,6,4,3,5,2,1};
        new MergeSort().sort(datas);
        print(datas);
    }



    public void print(Integer[] datas){
        System.out.println(Arrays.toString(datas));
    }
}