package com.lomo.algorithms.data_structure.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    void popAndPeek() {
        StackTest.popAndPeek(new ArrayStack<String>(10));
    }

    @Test
    void deepTest(){
        StackTest.deepTest(new ArrayStack<String>(10));
    }
}