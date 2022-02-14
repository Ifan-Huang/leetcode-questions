package com.codeforc.algorithm.sword.offer;

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
// 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
public class MinArray {

    public int minArray(int[] numbers) {
        int val = numbers[0];
        for(int i = 0; i < numbers.length; i++) {
            if (val > numbers[i]) return numbers[i];
            val = numbers[i];
        }
        return numbers[0];
    }
}