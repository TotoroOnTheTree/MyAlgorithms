package com.lomo.algorithms.data_structure.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {


    @Test
    void push() {
       QueueTest.push( new ArrayQueue<String>(5));
    }

}