package com.lomo.algorithms.data_structure.stack;

import com.lomo.algorithms.data_structure.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TODO .
 *
 * @Author: xumao
 * @DateTime: 2020/4/30 18:04
 * @Version: 1.0
 **/
public class StackTest {



    static void popAndPeek(Stack<String> st) {
        Assertions.assertEquals(st.peek(),null,"没有元素时出栈应该为null");
        Assertions.assertTrue(st.push("1"),"栈深度为10，入栈不应该报错");
        Assertions.assertEquals("1",st.pop(),"只有一个元素1，出栈只能是1");
    }


    static void deepTest(Stack<String> st){
        st.push("0");
        st.push("1");
        st.push("2");
        st.push("3");
        st.push("4");
        st.push("5");
        st.push("6");
        st.push("7");
        st.push("8");
        st.push("9");
        Assertions.assertFalse(st.push("10"),"到达栈深度最大值，不应该能继续入栈");
        Assertions.assertEquals("9",st.pop(),"栈顶应该是9");
        Assertions.assertTrue(st.push("11"),"栈空了一个位置出来，应该可以入栈了");
        Assertions.assertEquals("11",st.pop(),"刚入栈的11，出栈也该是11");
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        Assertions.assertEquals(null,st.pop(),"应该没有元素可以出栈了");
    }
}
