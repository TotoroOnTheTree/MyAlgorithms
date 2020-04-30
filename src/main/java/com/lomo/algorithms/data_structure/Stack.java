package com.lomo.algorithms.data_structure;

/**
 * 栈 .
 *
 * @Author: xumao
 * @DateTime: 2020/4/30 16:15
 * @Version: 1.0
 **/
public interface Stack<E> {

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();

    /**
     * 入栈
     * @param d
     * @return
     */
    Boolean push(E d);

    /**
     * 将栈顶元素出栈
     * @return
     */
    E pop();
}
