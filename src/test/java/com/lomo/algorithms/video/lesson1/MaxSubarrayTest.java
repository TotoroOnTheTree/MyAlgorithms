package com.lomo.algorithms.video.lesson1;

import org.junit.jupiter.api.Test;

/*
    最大连续子数组
 */
public class MaxSubarrayTest {

    Integer[] origin = new Integer[]{1,-2,3,10,-4,7,2,-5};

    /**
     * 穷举法
     */
    @Test
    void exhaustiveMethod(){
        int max = 0;
        Integer[] record = new Integer[2];
        for (int i=0; i<origin.length; i++){
            int subSum = 0;
            for (int j=i; j<origin.length; j++){
                subSum += origin[j];
                if(subSum>max){
                    max = subSum;
                    record[0]=i;
                    record[1]=j;
                }
            }
        }
        StringBuilder sbd = new StringBuilder("最大值为："+max)
                .append(", 子数组下标："+record[0])
                .append("，"+record[1])
                .append("最大子数组为:");
        for (int i=record[0]; i<=record[1]; i++){
            sbd.append(origin[i]).append(",");
        }
        System.out.println(sbd.toString());
    }

    /**
     * 分治法
     */
    @Test
    void halfMethod(){
        Integer[] max = halfCompare(origin,0,origin.length-1);
        StringBuilder sbd = new StringBuilder("最大值为："+max[2])
                .append(", 子数组下标："+max[0])
                .append("，"+max[1])
                .append("最大子数组为:");
        for (int i=max[0]; i<=max[1]; i++){
            sbd.append(origin[i]).append(",");
        }
        System.out.println(sbd.toString());
    }

    public Integer[] halfCompare(Integer[] origin,Integer from,Integer end){

        if(from == end){//递归到最小时的结束条件
            Integer[] record = new Integer[3];
            record[0]=from;
            record[1]=end;
            record[2]=origin[from];
            return record;
        }
        Integer mid_index = (from+end)/2;
        Integer[] left = halfCompare(origin,from,mid_index);//左边数组最大值
        Integer[] right = halfCompare(origin,mid_index+1,end);//右边数组最大值

        //交界处最长子数组最大值
        Integer join_left_max = 0;//左边的最大值
        Integer join_right_max = 0;//右边的最大值
        Integer sum_temp = 0;//临时累加变量
        Integer[] join = new Integer[3];
        for (int i=mid_index; i>=from; i--){
            sum_temp += origin[i];
            if(sum_temp>join_left_max){
                join_left_max = sum_temp;
                join[0]=i;
            }
        }
        sum_temp = 0;
        for (int i=mid_index+1; i<end; i++){
            sum_temp += origin[i];
            if(sum_temp>join_right_max){
                join_right_max = sum_temp;
                join[1]=i;
            }
        }
        Integer join_sum = join_left_max+join_right_max;
        join[2]= join_sum;
        Integer max = Math.max(Math.max(left[2],right[2]),join_sum);//找出最大子序列
        return max==left[2] ? left : max == right[2] ? right : join ;
    }


    /**
     *  分析法
     */
    @Test
    void analysisMethod(){

        long[] max = new long[2];
        long[] min = new long[2];
        long temp = 0L;
        for (int i=0; i<origin.length; i++){
            temp += origin[i];
            if(temp>=max[1]){
                max[1] = temp;
                max[0] = i;
            }
            if(temp < min[1]){
                min[1] = temp;
                min[0] = i;
            }
        }

        StringBuilder sbd = new StringBuilder("最大值为："+(max[1]-min[1]))
                .append(", 子数组下标："+min[0])
                .append("，"+max[0])
                .append("最大子数组为:");
        for (int i = (int) min[0]+1; i<=max[0]; i++){
            sbd.append(origin[i]).append(",");
        }
        System.out.println(sbd.toString());

    }

    /**
     * 动态规划法
     */
    @Test
    void DynamicPro(){

        long sum = 0L;
        long temp = 0L;
        int begin_index = 0;
        int end_index = 0;

        for (int i=0; i<origin.length; i++){
            if(temp>0){
                temp += origin[i];
            }else {
                temp = origin[i];
                begin_index = i;
            }
            if (temp>sum){
                sum = temp;
                end_index = i;
            }
        }

        StringBuilder sbd = new StringBuilder("最大值为："+sum)
                .append(", 子数组下标："+begin_index)
                .append("，"+end_index)
                .append("最大子数组为:");
        for (int i = begin_index; i<=end_index; i++){
            sbd.append(origin[i]).append(",");
        }
        System.out.println(sbd.toString());

    }
}
