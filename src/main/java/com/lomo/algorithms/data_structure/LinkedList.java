package com.lomo.algorithms.data_structure;

/**
 * 链表 .
 *
 * @Author: xumao
 * @DateTime: 2020/4/19 17:13
 * @Version: 1.0
 **/
public interface LinkedList<T> {


    Boolean add(T dd);

    Boolean delete(T dd);

    /**
     * 获取元素，index 从1开始
     * @param index
     * @return
     */
    T get(Integer index);
}
