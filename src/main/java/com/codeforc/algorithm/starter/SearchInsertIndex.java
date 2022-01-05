package com.codeforc.algorithm.starter;

/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Ifan·Huang
 **/
public class SearchInsertIndex {

    /**
     *
     * 定义left right变量记录数组位置，
     * 根据left right找到mid中间索引，进行比较
     * 当数值相同，返回索引
     * 当数值不同则按二分法继续进行索引 left = mid + 1 | right = mid - 1
     * 当 left == right - 1且没有匹配到值，则插入到right中
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int targetIndex = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(left == right || left == right - 1) {
                targetIndex = nums[mid] < target ? left + 1 : left;
            }
            if(nums[mid] < target) left = mid + 1;
            if(nums[mid] > target) right = mid - 1;
        }
        return targetIndex;
    }

    public static void main(String[] args) {
        SearchInsertIndex searchInsertIndex = new SearchInsertIndex();
//        int[] nums = {1,2,3,5,7,9,12,15,20};
        int[] nums = {3,5,7,9,10};

        int targerIndex = searchInsertIndex.searchInsert(nums, 8);
        System.out.println(targerIndex);
    }

}
