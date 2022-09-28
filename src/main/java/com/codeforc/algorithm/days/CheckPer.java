package com.codeforc.algorithm.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 */
public class CheckPer {

    public boolean checkPermutation(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        Character[] l = new Character[s1.length()];
        for(int i = 0; i < s1.length(); i++) {
            l[i] = s1.charAt(i);
        }
        Arrays.sort(l);

        for(int i = 0; i < s2.length(); i++) {
            if(binarySearch(l, s2.charAt(i))) {

            }
        }
        return l.length == 0;
    }

    public static boolean binarySearch(Character[] nums, Character target) {
        int left = 0; int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == nums[mid]) return true;
            if(target < nums[mid]) right = mid - 1;
            if(target > nums[mid]) left = mid + 1;
        }
        return false;
    }





    /**
     * 二分法
     */
    public static boolean binarySearch2(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            }
            if(nums[mid] < target) {
                left = mid + 1;
            }
            if(nums[mid] == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckPer checkPer = new CheckPer();
        boolean b = checkPer.checkPermutation("abc", "cba");
        System.out.println(b);
    }
}
