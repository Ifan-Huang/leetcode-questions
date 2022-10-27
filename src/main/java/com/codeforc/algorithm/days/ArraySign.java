package com.codeforc.algorithm.days;

/**
 * 已知函数signFunc(x) 将会根据 x 的正负返回特定值：
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * 返回 signFunc(product) 。
 * 示例 1：
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * 示例 2：
 * 输入：nums = [1,5,0,2,-3]
 * 输出：0
 * 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 */
public class ArraySign {

    public int arraySign(int[] nums) {
        boolean flag = true;
        for (int num : nums) {
            if(num == 0) return 0;
            if(num < 0) flag = !flag;
        }
        return flag ? 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = {9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        int i = new ArraySign().arraySign(nums);
        System.out.println(i);
    }
}