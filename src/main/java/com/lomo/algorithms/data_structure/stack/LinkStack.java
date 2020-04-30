package com.lomo.algorithms.data_structure.stack;

import com.lomo.algorithms.data_structure.LinkedList;
import com.lomo.algorithms.data_structure.Stack;
import com.lomo.algorithms.data_structure.linkedlist.LinkedListSentryDESC;

/**
 * 基于链表实现的简单栈.
 *  使用已实现的链表，每次查询栈顶、出栈，都需要遍历整个链表，效率低。
 *  可以重写链表的方法，查找时从尾部查找。
 *
 *  这里使用逆序的链表，可以避免多次遍历链表
 * @Author: xumao
 * @DateTime: 2020/4/30 16:31
 * @Version: 1.0
 **/
public class LinkStack<E> implements Stack<E> {
    private Integer deep;//栈深度
    private LinkedList<E> datas;
    private Integer top=-1;


    public LinkStack(Integer deep) {
        this.deep = deep;
        datas = new LinkedListSentryDESC<E>();
    }


    public E peek() {
        //这里获取
        return datas.get(top);
    }

    public Boolean push(E d) {
        if(top+1 >= deep){
            return false;
        }
        top++;
        return datas.add(d);
    }

    public E pop() {
        if(top==-1){
            return null;
        }
        E e = datas.get(top);
        datas.delete(e);
        top--;
        return e;
    }
}
