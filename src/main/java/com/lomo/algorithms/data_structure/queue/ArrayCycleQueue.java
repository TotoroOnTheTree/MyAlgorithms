package com.lomo.algorithms.data_structure.queue;

import com.lomo.algorithms.data_structure.Queue;

/**
 * 基于循环数组实现的队列 .
 *
 * @Author: xumao
 * @DateTime: 2020/5/7 23:10
 * @Version: 1.0
 **/
public class ArrayCycleQueue<E> implements Queue<E> {

    private Object[] queue;//队列
    private int head = 0;//指向头下标
    private int tail = 0;//指向尾下标
    private int initSize = 32;//默认初始化大小

    public ArrayCycleQueue(int initSize) {
        initSize++;//循环队列会浪费一个位置，所以给+1
        queue = new Object[initSize];
        this.initSize = initSize;
    }

    public ArrayCycleQueue() {
        initSize++;
        queue = new Object[this.initSize];
    }

    public Boolean push(E e) {
        if((tail+1)%initSize == head){//队满
            return false;
        }
        queue[tail++] = e;
        tail = tail % initSize;
        return true;
    }

    public E pop() {
        if(tail == head){
            return null;
        }
        E e = (E) queue[head++];
        head = head % initSize;
        return e;
    }
}
