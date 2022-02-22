package com.codeforc.algorithm.sword.offer;

//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//要求时间复杂度为O(n)。
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

//    public int maxSubArray(int[] nums) {
//        if(nums.length == 1) return nums[0];
//        int maxSum = Integer.MIN_VALUE;
//        for(int i = 0; i < nums.length; i++) {
//            int tempSum = nums[i];
//            if (i == nums.length - 1) {
//                tempSum = nums[i];
//                maxSum = Math.max(tempSum, maxSum);
//                break;
//            }
//            for(int j = i + 1; j < nums.length; j++) {
//                if(j == nums.length - 1) {
//                    if(tempSum > nums[j]) {
//                        maxSum = Math.max(tempSum, maxSum);
//                    }
//                }
//                tempSum += nums[j];
//                maxSum = Math.max(tempSum, maxSum);
//            }
//        }
//        return maxSum;
//    }

    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int[] nums = {-2,-1};
//        int[] nums = {-1, -2};
        int[] nums = {-1,-1,-2,-2};
        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.maxSubArray(nums);
        System.out.println(i);
    }

}
