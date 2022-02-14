package com.codeforc.algorithm.algorithm;

//二分查找法
public class BinarySearch {

    public static boolean binarySearch(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == nums[mid]) return true;
            if(target < nums[mid]) right = mid - 1;
            if(target > nums[mid]) left = mid + 1;
        }
        return false;
    }
}
