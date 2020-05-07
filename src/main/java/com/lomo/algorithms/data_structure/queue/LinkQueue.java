package com.lomo.algorithms.data_structure.queue;

import com.lomo.algorithms.data_structure.LinkedList;
import com.lomo.algorithms.data_structure.Queue;
import com.lomo.algorithms.data_structure.linkedlist.LinkedListSentryASC;

/**
 * 基于链表实现的队列 .
 *
 * @Author: xumao
 * @DateTime: 2020/5/7 22:53
 * @Version: 1.0
 **/
public class LinkQueue<E> implements Queue<E> {

    private LinkedList<E> queue;
    private int initSize;
    private int len = 0;

    public LinkQueue(int initSize) {
        this.initSize = initSize;
        this.queue = new LinkedListSentryASC<E>();
    }

    public LinkQueue() {
        this.initSize = 32;
        this.queue = new LinkedListSentryASC<E>();
    }

    public Boolean push(E e) {
        if(len>=initSize){
            return false;
        }
        len++;
        return queue.add(e);
    }

    public E pop() {
        if(len==0){
            return null;
        }
        E e = queue.get(0);
        queue.delete(e);
        len--;
        return e;
    }
}
