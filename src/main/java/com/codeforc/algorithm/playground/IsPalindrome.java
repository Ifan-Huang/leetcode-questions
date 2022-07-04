package com.codeforc.algorithm.playground;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 */
public class IsPalindrome {

    /**
     * 反转如果相同返回true
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return s.equals(sb.toString());
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean palindrome = isPalindrome.isPalindrome(1223);
        System.out.println(palindrome);
    }
}
