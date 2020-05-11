package com.lomo.algorithms.use_case;

import org.junit.jupiter.api.Test;

/**
 * 约瑟夫环问题，使用公式解决 .
 *
 * @Author: xumao
 * @DateTime: 2020/5/12 0:15
 * @Version: 1.0
 **/
public class YsfCycle {

    @Test
    public void test(){
        int i = ysfCycle(11, 3);
        System.out.println("最后剩余的位置下标为："+i);
    }

    int ysfCycle(int n,int m){
        int sub = 0;//1个人时为坐标0
        for(int i=1; i<=n ; i++){
            sub = (sub+m)%i;
        }
        return sub;
    }
}
