package com.lomo.algorithms.data_structure.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkStackTest {


    @Test
    void popAndPeek() {
        StackTest.popAndPeek(new LinkStack<String>(10));
    }

    @Test
    void deepTest(){
        StackTest.deepTest(new LinkStack<String>(10));
    }
}