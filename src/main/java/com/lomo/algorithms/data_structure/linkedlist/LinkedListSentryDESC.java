package com.lomo.algorithms.data_structure.linkedlist;

import com.lomo.algorithms.data_structure.LinkedList;

/**
 * 引入哨兵的单链表 .
 *  引入哨兵的目的是将没有节点时的增删，只有一个结点时的增，这些特殊情况统一
 *  该实现中链表是反着存的，例如存入的是：1,3,5,6,10
 *  head引用的next顺序为：head -> 10 -> 6 -> 5 -> 3 -> 1
 *  取的时候反向取就行了。
 *
 *  
 *
 * @Author: xumao
 * @DateTime: 2020/4/19 18:50
 * @Version: 1.0
 **/
public class LinkedListSentryDESC<T> implements LinkedList<T> {

    private Node<T> head = new Node<T>(null);//头结点,哨兵填充首节点，head永远指向哨兵节点
    private Integer len=0;//记录节点数量，当然也可以不要，获取总数只有每次遍历


    public Boolean add(T dd) {
        if(dd==null){
            return false;
        }
        Node<T> node = new Node<T>(dd);
        Node<T> next = head.getNext();
        head.setNext(node);
        node.setNext(next);
        len++;
        return true;
    }

    public Boolean delete(T dd) {
        Node<T> tmp = head;
        while (tmp.getNext()!=null){
            tmp = tmp.getNext();
            if(tmp.getData().equals(dd)){
                Node<T> t = head;
                while(t.getNext()!=null){
                    if(t.getNext().getData().equals(dd)){
                        t.setNext(tmp.getNext());
                        len--;
                        return true;
                    }
                    t = t.getNext();//这一句不放放在if前，否则只有一个结点时，t.getNext()为空
                }
            }
        }
        return false;//未找到该值的节点
    }

    /**
     * 获取元素，index 从1开始
     * @param index
     * @return
     */
    public T get(Integer index) {
        if(len == 0 ||  index<0 || index+1 > len){
            return null;
        }
        Node<T> tmp = head;
        int i=len;//这里反向取数据
        while(tmp.getNext()!=null){
            tmp = tmp.getNext();
            if(i==index+1){
                return tmp.getData();
            }
            i--;
        }
        return null;
    }


    /*
        内部结点
     */
    private class Node<T>{
        private T data;//结点数据
        private Node<T> next;//下个结点


        public Node() {
        }

        public Node(T data){
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
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
