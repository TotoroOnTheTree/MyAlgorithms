package com.lomo.algorithms.data_structure;

/**
 * TODO .
 *
 * @Author: xumao
 * @DateTime: 2020/4/19 19:09
 * @Version: 1.0
 **/
public class LinkedListFactory<T> {

    /**
     *  获取给定类型的链表实现
     * @param type  1 - 单链表（无哨兵）
     *              2- 单链表（有哨兵）逆向实现
     *              3-单链表（有哨兵）正向实现
     * @return
     */
    public  LinkedList<T> getLinkedList(Integer type){
        switch (type){
            case 2:
                return new LinkedListSentry<T>();//哨兵逆向链表
            case 3:
                return new LinkedListSentry2<T>();//哨兵正向链表
            case 1:
                default:return new LinkedListISimple<T>();
        }
    }
}
