package com.lomo.algorithms.data_structure;

/**
 * 队列 .
 *
 * @Author: xumao
 * @DateTime: 2020/5/6 23:11
 * @Version: 1.0
 **/
public interface Queue<E> {

    /**
     * 入队
     * @param e
     * @return
     */
    Boolean push(E e);

    /**
     * 出队
     * @return
     */
    E pop();
}
