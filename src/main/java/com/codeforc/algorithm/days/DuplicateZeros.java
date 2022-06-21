package com.codeforc.algorithm.days;

import sun.security.util.ArrayUtil;

import java.util.Arrays;

/**
 * 给你一个长度固定的整数数组arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组就地进行上述修改，不要从函数返回任何东西。
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int in = arr[i];
            if(in != 0) continue;
            int temp = 0;
            for(int j = i+1; j < arr.length; j++) {
                if(j == i+1) {
                    temp = arr[j];
                    arr[j] = 0;
                    continue;
                }
                arr[j + 1] = temp;
            }
        }
    }
}
