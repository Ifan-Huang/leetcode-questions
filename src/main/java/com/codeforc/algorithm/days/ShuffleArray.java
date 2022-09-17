package com.codeforc.algorithm.days;

/**
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * 示例 1：
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * 示例 2：
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 */
public class ShuffleArray {

    /**
     * 通过N，找到中心点，N坐标+1为中心点
     */
    public int[] shuffle(int[] nums, int n) {
        if(null == nums || nums.length == 0) return null;
        int[] res = new int[nums.length];
        int xIndex = 0;
        int yIndex = n;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                res[i] = nums[xIndex];
                xIndex++;
            } else {
                res[i] = nums[yIndex];
                yIndex++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,3,2,1};
        int n = 4;
        ShuffleArray suffleArray = new ShuffleArray();
        int[] shuffle = suffleArray.shuffle(nums, n);
        for (int i : shuffle) {
            System.out.println(i);
        }
    }
}
