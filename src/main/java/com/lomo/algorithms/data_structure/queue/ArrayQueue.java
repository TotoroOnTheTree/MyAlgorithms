package com.lomo.algorithms.data_structure.queue;

import com.lomo.algorithms.data_structure.Queue;

/**
 * 基于数组实现的队列 .
 *
 * @Author: xumao
 * @DateTime: 2020/5/6 23:15
 * @Version: 1.0
 **/
public class ArrayQueue<E> implements Queue<E> {

    private Object[] queue;//队列
    private int head = 0;//指向头下标
    private int tail = 0;//指向尾下标
    private int initSize = 32;//默认初始化大小

    public ArrayQueue(int initSize) {
        queue = new Object[initSize];
        this.initSize = initSize;
    }

    public ArrayQueue() {
        queue = new Object[this.initSize];
    }

    public Boolean push(E e) {
        if(tail == initSize){
            if(head == 0){
                return false;//队列是满的，无法入队
            }
            for (int i = 0; i < tail - head; i++) {
                queue[i] = queue[head+i];
            }
            tail = tail - head ;
            head = 0;
        }
        queue[tail++] = e;
        return true;
    }

    public E pop() {
        if(tail == head){
            return null;
        }
        return (E) queue[head++];
    }
}
