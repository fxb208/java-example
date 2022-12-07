package leetcode.od3.string;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
public class Leetcode58 {
    public static void main(String[] args) {
        Leetcode58 yb = new Leetcode58();
        yb.lengthOfLastWord("   fly me   to   the moon  ");
    }

    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        for(int i= arr.length-1;i>=0;i--){
            if(!arr[i].equals(" ")){
                return arr[i].length();
            }
        }
        return s.length();
    }
}
