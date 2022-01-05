package com.codeforc.algorithm.starter;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 示例 1：
 * 输入：s = ['h','e','l','l','o']
 * 输出：['o','l','l','e','h']
 *
 * 示例 2：
 * 输入：s = ['H','a','n','n','a','h']
 * 输出：['h','a','n','n','a','H']
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Ifan·Huang
 **/
public class ReserveString {

    public void reverseString(char[] s) {
        int mid = (s.length - 1) / 2;
        System.out.println(mid);
        for (int i = 0; i < (s.length) / 2; i++) {
            char temp = s[i];
            int j = s.length - 1 - i;
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};
        new ReserveString().reverseString(s);
    }
}
