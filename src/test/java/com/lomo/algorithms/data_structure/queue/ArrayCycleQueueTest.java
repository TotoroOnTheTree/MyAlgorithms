package com.lomo.algorithms.data_structure.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCycleQueueTest {

    @Test
    void test(){
        //测试取余运算的结果
        System.out.println(4%8);
        System.out.println(5%8);
        System.out.println(9%6);
        System.out.println(-5%8);
        System.out.println(9%-6);
        System.out.println(5%8.2);
        System.out.println(9%6.2);
        System.out.println(-5%8.2);
        System.out.println(9%-6.2);
    }


    @Test
    void push(){
        QueueTest.push(new ArrayCycleQueue<String>(5));
    }

}