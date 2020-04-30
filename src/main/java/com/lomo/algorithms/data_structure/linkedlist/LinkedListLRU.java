package com.lomo.algorithms.data_structure.linkedlist;

import com.lomo.algorithms.data_structure.LinkedList;

/**
 * 基于双向链表的简单LRU算法实现.
 *  当查询某个元素时，将该节点移到链尾
 *  添加时，如果已经没有容量了，则移除头部的元素
 *
 * @Author: xumao
 * @DateTime: 2020/4/30 18:40
 * @Version: 1.0
 **/
public class LinkedListLRU<E> implements LinkedList<E> {


    private Node<E> head = new Node<E>();//头结点指向哨兵
    private Node<E> tail = head;//尾结点初始化时也指向哨兵
    private int len = 0;//长度
    private int size = 0;//容量

    public LinkedListLRU(int size) {
        this.size = size;
    }

    public Boolean add(E dd) {
        if(len >= size){
            removeHead();
        }
        //因为有哨兵，添加只需要拿着尾结点往后加就行
        Node<E> a = new Node<E>(dd);
        tail.next = a;
        a.pre = tail;
        tail = a;
        len++;
        return true;
    }


    private Boolean flush(Node<E> tmp) {
        //从当前位置删除
        tmp.pre.next = tmp.next;
        tmp.next.pre = tmp.pre;
        //加入到尾部
        tail.next = tmp;
        tmp.pre = tail;
        tmp.next = null;//放到尾部，置空指针
        tail = tmp;
        return true;
    }


    public Boolean delete(E dd) {
        //1. 遍历链表找到值相等的节点
        Node<E> tmp = head;
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

    private Boolean removeHead(){
        Node<E> tmp = head.next;
        head.next = tmp.next;
        tmp.next.pre = head;
        return true;
    }

    public E get(Integer index) {
        if(len==0 ||  index<0 || index+1>len){
            return null;
        }
        //遍历链表找对应位置的
        int i=0;
        Node<E> tmp = head;
        while (i<=index){
            tmp = tmp.next;
            i++;
        }
        flush(tmp);
        return tmp.getData();
    }

    @Override
    public String toString() {
        Node<E> tmp = head;
        String str = "";
        while (tmp.next!=null){
            tmp = tmp.next;
            str+=tmp.getData().toString()+",";
        }
        return str.substring(0,str.length()-1);
    }

    /*
            内部结点
         */
    private class Node<E>{
        private E data;//结点数据
        private Node<E> pre;//上个结点
        private Node<E> next;//下个结点


        public Node() {
        }

        public Node(E data){
            this.data = data;
        }

        public Node(E data, Node<E> pre, Node<E> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        public Node<E> getPre() {
            return pre;
        }

        public void setPre(Node<E> pre) {
            this.pre = pre;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
