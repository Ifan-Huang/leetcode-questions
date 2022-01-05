package com.codeforc.algorithm.starter;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Ifan·Huang
 **/
public class SortedSquares {

    /**
     * 以min为中心取出左右指针，并进行比较
     */
    public int[] sortedSquares(int[] nums) {
        int[] squaresNum = new int[nums.length];
        int[] sortedSquaresNum = new int[nums.length];
        int min = nums[0] * nums[0];
        int leftIndex = 0, rightIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            int squares = nums[i] * nums[i];
            squaresNum[i] = squares;
            if(squares <= min) {
                min = squares;
                leftIndex = i - 1;
                rightIndex = i;
            }
        }

        for(int i = 0; i < sortedSquaresNum.length; i++) {
            if(rightIndex >= sortedSquaresNum.length || (leftIndex >= 0 && squaresNum[leftIndex] <= squaresNum[rightIndex])) {
                sortedSquaresNum[i] = squaresNum[leftIndex];
                if(leftIndex >= 0) leftIndex--;
                continue;
            }
            if(leftIndex < 0 || (rightIndex < nums.length && squaresNum[leftIndex] > squaresNum[rightIndex])) {
                sortedSquaresNum[i] = squaresNum[rightIndex];
                rightIndex++;
            }
        }
        return sortedSquaresNum;
    }


    public static void main(String[] args) {
//        int[] nums = {-4, -1, 0, 3, 10};
        int[] nums = {-7,-3,2,3,11};
        SortedSquares sortedSquares = new SortedSquares();
        int[] ints = sortedSquares.sortedSquares(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
