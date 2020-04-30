package com.lomo.algorithms.data_structure.linkedlist;

import com.lomo.algorithms.data_structure.LinkedList;

/**
 * 双向链表 .
 *
 * @Author: xumao
 * @DateTime: 2020/4/30 15:57
 * @Version: 1.0
 **/
public class LinkedListDefault<T> implements LinkedList<T> {

    private Node<T> head = new Node<T>();//头结点指向哨兵
    private Node<T> tail = head;//尾结点初始化时也指向哨兵
    private int len = 0;//长度


    public Boolean add(T dd) {
        //因为有哨兵，添加只需要拿着尾结点往后加就行
        Node<T> a = new Node<T>(dd);
        tail.next = a;
        a.pre = tail;
        tail = a;
        len++;
        return true;
    }

    public Boolean delete(T dd) {
        //1. 遍历链表找到值相等的节点
        Node<T> tmp = head;
        while (tmp.next!=null){
            tmp=tmp.next;//2.拿到下一个节点
            if(tmp.getData().equals(dd)){//3.这里的比较应该引入compareTo的，简单实现先不考虑
                //找前一个结点完成链表删除，如果是双向链表这里就很方便了
                tmp.pre.next = tmp.next;
                if(tmp.next!=null){//排除最后一个元素时，没有下一个元素
                    tmp.next.pre = tmp.pre;
                    tmp.next = null;
                }
                tmp.pre = null;
                len --;
                return true;
            }
        }
        return false;
    }

    public T get(Integer index) {
        if(len==0 ||  index<0 || index+1>len){
            return null;
        }
        //遍历链表找对应位置的
        int i=0;
        Node<T> tmp = head;
        while (i<=index){
            tmp = tmp.next;
            i++;
        }
        return tmp.getData();
    }


    /*
        内部结点
     */
    private class Node<T>{
        private T data;//结点数据
        private Node<T> pre;//上个结点
        private Node<T> next;//下个结点


        public Node() {
        }

        public Node(T data){
            this.data = data;
        }

        public Node(T data, Node<T> pre, Node<T> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        public Node<T> getPre() {
            return pre;
        }

        public void setPre(Node<T> pre) {
            this.pre = pre;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
