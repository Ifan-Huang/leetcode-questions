package com.codeforc.algorithm.starter;

import java.util.*;

/**
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) {
                    left++;
                    right--;
                }
                if(sum < target) {
                    left++;
                }
                if(sum > target) {
                    right--;
                }
                if(stack.size() == 0 || Math.abs(target - stack.getLast()) > Math.abs(target - sum)) {
                    stack.add(sum);
                }
            }
        }
        return stack.getLast();
    }

        public static void main(String[] args) {
            int[] nums = {-1,2,1,-4};
//        int[] nums = {0,0,0};
            int i = new ThreeSumClosest().threeSumClosest(nums, 1);
            System.out.println("result : " + i);
    }

}
