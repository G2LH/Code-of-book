import java.util.ArrayList;
import java.util.List;

//1.()()  2.(())两种情况
public class kuohao_review {
    //1.给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            backtrack(ans, "", 0, 0, n);
            return ans;
        }
        public void backtrack(List<String> ans, String cur, int open, int close, int max){
            if (cur.length() == max * 2) {
                ans.add(cur);
                return;
            }

            if (open < max)
                backtrack(ans, cur+"(", open+1, close, max);
            if (close < open)
                backtrack(ans, cur+")", open, close+1, max);
        }

        //2.给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
        //用 dp[i] 表示以 i 结尾的最长有效括号；
        //    当 s.charAt(i) 为 '('时,不可能组成有效的括号，因此dp[i]= 0；
        //    当 s.charAt(i) 为 '）'时分两种情况
        //    当 s.charAt(i) 为 '('，那么 dp[i] = dp[i-2] + 2；
        //    当 s.charAt(i) 为 '）' 并且 s.charAt(i-dp[i-1] - 1) 为 (，那么 dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]；
        public int longestValidParentheses(String s) {
            int maxans = 0;
            int dp[] = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            return maxans;
        }
    }
