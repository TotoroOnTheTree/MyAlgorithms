package com.lomo.algorithms.data_structure.queue;

import com.lomo.algorithms.data_structure.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {


    Queue<String> q = new ArrayQueue<String>(5);

    @Test
    void push() {
        q.push("你");
        q.push("好");
        q.push("，");
        q.push("大");
        q.push("雄");
        Assertions.assertFalse(q.push("额"),"队列应该满了，不能插入才对");

        System.out.println(q.pop());
        Assertions.assertTrue(q.push("哈"),"应该可以插入才对");
        for (int i = 0; i < 5; i++) {
            System.out.println(q.pop());
        }
    }

}