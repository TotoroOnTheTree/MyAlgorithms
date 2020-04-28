package com.lomo.algorithms.data_structure;

/**
 * 单链表 .
 *  不引入哨兵实现
 * @Author: xumao
 * @DateTime: 2020/4/19 17:10
 * @Version: 1.0
 **/
public class LinkedListISimple<T> implements LinkedList<T>{

    private Integer len = 0;//长度
    private Node<T> head ;//头结点
    private Node<T> tail ;//尾结点



    public Boolean add(T dd) {
        if(len==0){
            Node<T> node = new Node<T>(dd);
            node.setNext(node);
            head = node;
            tail = node;
        }else {
            Node<T> node = new Node<T>(dd);
            tail.setNext(node);
            tail = node;
        }
        len++;
        return true;
    }

    public Boolean delete(T dd) {
        if(len == 0){
            return false;
        }
        Node<T> node = head;
        for (int i=0; i<len;i++){

            if(node.getData().equals(dd)){//找到结点了
                if(len == 1){//只有一个结点
                    head = null;
                    tail = null;
                }
                Node<T> tmp = head;
                for (int j=0; j<i;j++){//找到前一个结点
                    if(tmp.next.getData().equals(dd)){
                        tmp.setNext(node.getNext());
                        break;
                    }
                    tmp = tmp.next;
                }
                len--;
                return true;
            }

            if(node.next == null){//没有后继结点了
                return false;
            }
            node = node.next;
        }
        return false;//没有找到该结点
    }

    /**
     * 获取元素，index从1开始
     * @param index
     * @return
     */
    public T get(Integer index) {
        if(len==0 || index > len){
            return null;
        }
        Node<T> tmp = head;
        for (int i=0; i<len;i++){
            if(i== index -1){
                return tmp.getData();
            }
            tmp = tmp.next;
        }
        return null;
    }


    /*
        内部结点
     */
    class Node<T>{
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
