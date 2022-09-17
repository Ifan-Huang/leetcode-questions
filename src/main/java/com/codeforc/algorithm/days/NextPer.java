package com.codeforc.algorithm.days;

/**
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 */
public class NextPer {

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int rI = nums.length - 1;
        int lI = 0;
        boolean breakflag = false;
        boolean allSorted = true;
        for(int i = nums.length - 1; i > 0; i--) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    lI = j;
                    rI = i;
                    breakflag = true;
                    allSorted = false;
                    break;
                }
            }
            if(breakflag) {
                break;
            }
        }
        int tmp = 0;
        if(allSorted) {
            for(int i = 0; i < nums.length / 2; i++) {
                int sortTmp = nums[i];
                nums[i] = nums[nums.length - 1 -i];
                nums[nums.length - 1 -i] = sortTmp;
            }
            return;
        }
        for(int i = rI; i >= lI; i--) {
            if(i == rI) {
                tmp = nums[i];
            }
            if(i == lI) {
                nums[i] = tmp;
                break;
            }
            nums[i] = nums[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1};
        NextPer nextPer = new NextPer();
        nextPer.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
