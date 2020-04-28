package com.lomo.algorithms.data_structure;

/**
 * 引入哨兵的单链表 . .
 *  引入哨兵的目的是将没有节点时的增删，只有一个结点时的增，这些特殊情况统一
 *    该实现中链表是正序的，例如存入的是：1,3,5,6,10
 *   head引用的next顺序为：head -> 1 -> 3 -> 5 -> 6 -> 10、
 * @Author: xumao
 * @DateTime: 2020/4/28 21:09
 * @Version: 1.0
 **/
public class LinkedListSentry2<T> implements LinkedList<T> {

    private Node<T> head = new Node<T>(null);//头结点指向哨兵
    /*
        为了不每次都遍历链表，需要增加尾结点
        初始化时，尾结点也指向哨兵
     */
    private Node<T> tail = head;

    private int len = 0;//长度主要用在根据index找数据时判断超长没，超过了长度可以快速返回


    public Boolean add(T dd) {
        //因为有哨兵，添加只需要拿着尾结点往后加就行
        Node<T> a = new Node<T>(dd);
        tail.next = a;
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
                Node<T> pre = head;
                while (pre.next!=null){
                    if(pre.next==tmp){//4.如果下个结点就是要找的，那么就执行删除逻辑
                        pre.next = tmp.next;
                        len--;
                        return true;
                    }
                    pre = pre.next;
                }
            }
        }
        return false;
    }

    public T get(Integer index) {
        if(index>len){
            return null;
        }
        //遍历链表找对应位置的
        int i=1;
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
