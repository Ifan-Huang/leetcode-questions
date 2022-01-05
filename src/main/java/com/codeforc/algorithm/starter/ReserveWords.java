package com.codeforc.algorithm.starter;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Ifan·Huang
 **/
public class ReserveWords {

    public String reverseWords(String s) {
        String[] singleWordArray = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < singleWordArray.length; i++) {
            String singleWord = singleWordArray[i];
            char[] singleWordChar = singleWord.toCharArray();
            for(int j = 0; j < singleWordChar.length / 2; j++) {
                char temp = singleWordChar[j];
                singleWordChar[j] = singleWordChar[singleWordChar.length - 1 - j];
                singleWordChar[singleWordChar.length - 1 - j] = temp;
            }
            stringBuilder.append(singleWordChar);
            if(i != singleWordArray.length - 1) stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReserveWords reserveWords = new ReserveWords();
        String s = reserveWords.reverseWords("东京 爱情 故事");
        System.out.println(s);
    }
}
