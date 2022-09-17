package com.codeforc.algorithm.days;

import java.util.HashMap;

/**
 * Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.
 * A substring is a contiguous sequence of characters within a string.
 * Example 1:
 * Input: s = "aa"
 * Output: 0
 * Explanation: The optimal substring here is an empty substring between the two 'a's.
 * Example 2:
 * Input: s = "abcaasaabzx"
 * Output: 2
 * Explanation: The optimal substring here is "bc".
 */
public class MaxLengthBetweenEqualsCharacters {

    /**
     * 应该用双指针做leftIndex rightIndex
     */
    public int maxLengthBetweenEqualsCharacters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, i);
            } else {
                Integer left = map.get(c);
                int d = i - left - 1;
                max = Math.max(max, d);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcaasaabzx";
        MaxLengthBetweenEqualsCharacters maxLengthBetweenEqualsCharacters = new MaxLengthBetweenEqualsCharacters();
        int i = maxLengthBetweenEqualsCharacters.maxLengthBetweenEqualsCharacters(s);
        System.out.println(i);
    }
}
