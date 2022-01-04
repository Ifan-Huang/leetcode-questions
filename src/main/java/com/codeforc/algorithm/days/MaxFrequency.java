package com.codeforc.algorithm.days;

/**
 * Author: Ifan·Huang
 * Description: 最高频元素的频数
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 *
 **/
public class MaxFrequency {

    /**
     * 添加一个数组保存原数组的排序对象
     * @param nums 参数数组
     * @param k 参考值
     * @return 频次
     */
    public int maxFrequency(int[] nums, int k) {
        int length = nums.length;
        sort(nums);
        int frequency = 0;
        for(int i = length - 1; i > 0; i--) {
            int enableK = k;
            int tempfre = 1;
            for(int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j];
                if(diff > k) {
                    break;
                }
                //diff <= k时，
                if(enableK - diff < 0) {
                    continue;
                }
                enableK -= diff;
                tempfre++;
            }
            if(tempfre > frequency) frequency = tempfre;
        }
        return frequency;
    }

    public void sort(int[] nums) {
        process(nums, 0, nums.length - 1);
    }

    public void process(int[] nums, int left, int right) {
        if(left >= right) return;
        int[] equalsArray = netherlandsFlag(nums, left, right);
        process(nums, left, equalsArray[0] - 1);
        process(nums, equalsArray[1] + 1, right);
    }

    public int[] netherlandsFlag(int[] nums, int left, int right) {
        if(left > right) return new int[]{-1, -1};
        if(left == right) return new int[]{left, right};
        int less = left - 1;
        int more = right;
        int pointer = left;
        while(pointer < more) {
            if(nums[pointer] == nums[right]) {
                pointer++;
            } else if(nums[pointer] < nums[right]) {
                swap(nums, pointer++, ++less);
            } else {
                swap(nums, pointer, --more);
            }
        }
        swap(nums, more, right);
        return new int[] {less + 1, more};
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums ={9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,
                9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,
                9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,
                9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,
                9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,
                9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966};
        int k = 3056;
        MaxFrequency maxFrequency = new MaxFrequency();
        int frequency = maxFrequency.maxFrequency(nums, k);
        System.out.println("frequency: " + frequency);
    }
}
