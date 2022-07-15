package com.codeforc.algorithm.days;

import com.codeforc.algorithm.algorithm.QuickSort;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class ThreeNum {

    /**
     * 先将数组进行排序，排序之后。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeNum(int[] nums) {
       Arrays.sort(nums);
       Set<List<Integer>> set = new HashSet<>();
       for(int i = 0; i < nums.length; i++) {
           int left = i + 1, right = nums.length - 1;
           while(left < right) {
               if(nums[i] + nums[left] + nums[right] == 0) {
                   set.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                   left++;
                   right--;
               } else if(nums[i] + nums[left] + nums[right] < 0) {
                    left++;
               } else {
                   right--;
               }
           }
       }
       List<List<Integer>> lists = new ArrayList<>(set);
       return lists;
    }



    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
//        int[] nums = {1,2,-2,-1};
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeNum threeNum = new ThreeNum();
        List<List<Integer>> lists = threeNum.threeNum(nums);
        System.out.println(lists);
    }
}
