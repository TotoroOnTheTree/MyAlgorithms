package com.lomo.algorithms.data_structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTest {
    LinkedListFactory<Integer> factory = new LinkedListFactory<Integer>();
    private Integer type = 3;

    /**
     * 测试没有数据时的增删查
     */
    @Test
    void test1() {
        LinkedList<Integer> linkedList = factory.getLinkedList(type);
        //查询
        linkedList.get(2);
        //删除
        linkedList.delete(3);
        //新增
        linkedList.add(1);
    }

    /*
        测试边界情况： 只有一个结点
    *
    */
    @Test
    void test2() {
        LinkedList<Integer> linkedList =  factory.getLinkedList(type);
        //只有一个结点
        Assertions.assertTrue(linkedList.add(1),"一个结点添加失败");
        Assertions.assertEquals(linkedList.get(2),null);
        Assertions.assertEquals(linkedList.get(1),1);
        Assertions.assertFalse(linkedList.delete(2),"删除2成功了，但是没有添加这个元素");
        Assertions.assertTrue(linkedList.delete(1),"删除1不应该失败");
        Assertions.assertFalse(linkedList.delete(1),"空链表不应该删除成功");
        Assertions.assertEquals(linkedList.get(1),null);


        //两个结点
        linkedList.add(2);

    }

    /**
     * 测试常规数据的操作
     */
    @Test
    void test3() {
        LinkedList<Integer> linkedList =  factory.getLinkedList(type);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(10);

        Assertions.assertEquals(linkedList.get(6),null);
        Assertions.assertEquals(linkedList.get(3),3);
        Assertions.assertEquals(linkedList.get(4),5);
        Assertions.assertFalse(linkedList.delete(4),"4这个元素不存在，不应该删除成功");
        Assertions.assertTrue(linkedList.delete(5),"5这个元素是存在的，应该删除成功才对");
        Assertions.assertEquals(linkedList.get(4),10);
    }
}