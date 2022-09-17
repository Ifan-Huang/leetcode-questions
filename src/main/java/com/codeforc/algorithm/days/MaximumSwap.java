package com.codeforc.algorithm.days;

import java.util.Collections;

/**
 * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you can get.
 *
 *  Example 1:
 * Input: num = 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 *
 * Example 2:
 * Input: num = 9937
 * Output: 9973
 * Explanation: No swap.
 */
public class MaximumSwap {

    /**
     * 参数中的数字排列未不规则排列，需要得到最大值的swap，根据规律可得出，
     * 位数最大的是待调换位置，如果没有则第二大的为待调换位置，以此类推.
     */
    public int maximumSwap(int num) {
        Integer number = num;
        String nums = number.toString();
        for(int i = 0; i < nums.length(); i++) {
            Character c = nums.charAt(i);
            int n = (int)c;
            System.out.println(n);
        }
        return 0;
    }

    public static void main(String[] args) {
        MaximumSwap maximumSwap = new MaximumSwap();
        int i = maximumSwap.maximumSwap(9937);
    }

}
