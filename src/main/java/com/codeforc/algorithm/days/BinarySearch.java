package com.codeforc.algorithm.days;

/**
 * 给定一个个元素有序的（升序）整型数组ums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * 提示：
 * 你可以假设 nums中的所有元素是不重复的。
 * n将在[1, 10000]之间。
 * nums的每个元素都将在[-9999, 9999]之间。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Ifan·Huang
 **/

public class BinarySearch {

    /**
     * 二分搜索法
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                right = mid - 1;
            }
            if(nums[mid] > target) {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1,2, 6, 8, 13,42,45, 48};
        int target = 8;
        BinarySearch binarySearch = new BinarySearch();
        int search = binarySearch.search(nums, target);
        System.out.println(" target = " + target + " 时, index = " + search);
    }
}