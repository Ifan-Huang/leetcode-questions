package com.codeforc.algorithm.days;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.*;

/**
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。
 * 如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * 请你返回排序后的数组。
 * 示例 1：
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 *
 * 示例 2：
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 */
public class FrequencySort {

    public int[] frequencySort(int[] nums) {
        //
        Arrays.sort(nums);
        int[] tar = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            tar[i] = nums[nums.length - i - 1];
        }

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : tar) {
            if(map.containsKey(num)) {
                Integer valN = map.get(num);
                map.put(num, ++valN);
            } else {
                map.put(num, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        int[] res = new int[nums.length];
        int index = 0;

        for (Map.Entry<Integer, Integer> integerIntegerEntry : list) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();
            while(value > 0) {
                res[index] = key;
                value--;
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,3,2};
        FrequencySort frequencySort = new FrequencySort();
        int[] ints = frequencySort.frequencySort(nums);
        System.out.println(Arrays.toString(ints));
    }

}