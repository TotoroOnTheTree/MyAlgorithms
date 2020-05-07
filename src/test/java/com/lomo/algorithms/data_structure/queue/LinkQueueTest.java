package com.lomo.algorithms.data_structure.queue;

import com.lomo.algorithms.data_structure.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkQueueTest {

    @Test
    void push() {
        QueueTest.push(new LinkQueue<String>(5));
    }
}