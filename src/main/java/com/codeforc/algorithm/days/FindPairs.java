package com.codeforc.algorithm.days;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个整数数组和一个整数k，你需要在数组里找到 不同的k-diff 数对，并返回不同的 k-diff 数对 的数目。
 * 这里将k-diff数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 *
 * 示例 1：
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 */
public class FindPairs {

    /**
     * 暴力法
     */
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums.length <= 1) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int y = nums[j];
                if(y - x > k) break;
                if( (y - x == k) && !set.contains(y+x) ) {
                    set.add(y+x);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        FindPairs findPairs = new FindPairs();
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        int pairs = findPairs.findPairs(nums, k);
        System.out.println(pairs);
    }

}
