package DP;
//状态定义：
//转移方程：
//初始状态：
//返回值：
import java.util.List;
//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//说明：
//        拆分时可以重复使用字典中的单词。
//        你可以假设字典中没有重复的单词。

//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
public class DP_Word {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    //给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
    //假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
    //注意：每次拼写时，chars 中的每个字母都只能用一次。
    //返回词汇表 words 中你掌握的所有单词的 长度之和。
    //单词长度覆盖：
    public int countCharacters(String[] words, String chars) {
        if(words == null || chars == null){
            return 0;
        }
        int[] chars_count = count(chars); // 统计字母表的字母出现次数
        int res = 0;
        for (String word : words) {
            int[] word_count = count(word); // 统计单词的字母出现次数
            if (contains(chars_count, word_count)) {
                res += word.length();
            }
        }
        return res;
    }

    // 检查字母表的字母出现次数是否覆盖单词的字母出现次数
    public boolean contains(int[] chars_count, int[] word_count) {
        for (int i = 0; i < 26; i++) {
            if (chars_count[i] < word_count[i]) {
                return false;
            }
        }
        return true;
    }
    // 统计 26 个字母出现的次数
    public int[] count(String word) {
        int[] counter = new int[26];
        for (int i = 0; i < word.length(); i++) {
            counter[word.charAt(i)-'a']++;
        }
        return counter;
    }
}
