package com.lomo.algorithms.data_structure.stack;

import com.lomo.algorithms.data_structure.Stack;

/**
 * 基于数组实现的简单栈.
 * 不支持动态扩容
 *
 * @Author: xumao
 * @DateTime: 2020/4/30 16:21
 * @Version: 1.0
 **/
public class ArrayStack<E> implements Stack<E> {

    private Integer deep;//栈深度
    private Object[] datas;
    private Integer top=-1;

    public ArrayStack(Integer deep) {
        this.deep = deep;
        this.datas = new Object[deep];
    }

    public E peek() {
        if(top==-1){
            return null;
        }
        return (E) datas[top];
    }

    public Boolean push(E d) {
        if(top+1>=deep){
            return false;
        }
        datas[++top] = d;
        return true;
    }

    public E pop() {
        if(top==-1){
            return null;
        }
        E d = (E) datas[top];
        datas[top--] = null;
        return d;
    }
}
