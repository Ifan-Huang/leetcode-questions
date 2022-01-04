package com.codeforc.algorithm.days;

/**
 * Author: Ifan·Huang
 * Description:
 * 给你一个 从 0 开始的排列 nums（下标也从 0 开始）。请你构建一个 同样长度 的数组 ans ，其中，对于每个 i（0 <= i < nums.length），都满足 ans[i] = nums[nums[i]] 。返回构建好的数组 ans 。
 * 从 0 开始的排列 nums 是一个由 0 到 nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。
 **/
public class BuildArray {

    public int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length;i++) {
            arr[i] = nums[nums[i]];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
        BuildArray buildArray = new BuildArray();
        int[] ints = buildArray.buildArray(nums);

        System.out.println(ints);
    }
}
