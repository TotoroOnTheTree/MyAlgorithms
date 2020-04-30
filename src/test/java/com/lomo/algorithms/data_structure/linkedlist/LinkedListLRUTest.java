package com.lomo.algorithms.data_structure.linkedlist;

import com.lomo.algorithms.data_structure.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListLRUTest {

    @Test
    void testLRU() {
        LinkedList<String> ll = new LinkedListLRU<String>(5);
        ll.add("a");
        ll.add("b");
        ll.add("c");
        Assertions.assertEquals("a,b,c",ll.toString(),"刚添加的顺序就是abc");
        ll.get(1);
        Assertions.assertEquals("a,c,b",ll.toString(),"b被读了一次，应该在最后");
        ll.add("d");
        ll.add("e");
        ll.add("f");
        Assertions.assertEquals("c,b,d,e,f",ll.toString(),"a应该被过期了才对");

    }

}