/*有效的括号
public class LeetCode {
    public static boolean isValid(String s) {
    char[] s1 = s.toCharArray();
    int l = s1.length;
    Stack<Character> s2 = new Stack<Character>();
        for(int i=0; i<l; i++){
            System.out.println(s1[i]);
            if(s1[i] == '{' || s1[i] == '[' || s1[i] == '(') {
                s2.push(s1[i]);
            }
            if(s1[i] == '}'){
                if(s2.peek() == '{')
                    s2.pop();
                else
                    return false;
            }
            if(s1[i] == ')'){
                if(s2.peek() == '(')
                    s2.pop();
                else
                    return false;
            }
            if(s1[i] == ']'){
                if(s2.peek() == '[')
                    s2.pop();
                else
                    return false;
            }
            System.out.println(s2);
    }
        return s2.isEmpty();
}
    public static void main(String[] args){
        String s = "{}(()}";
        boolean a = isValid(s);
        System.out.println(a);
    }
}
*/
/*至少是其他数字两倍的最大数
class LeetCode {
    public static int dominantIndex(int[] nums) {
        int max = nums[0];
        int index = 0;
        int p = -1;
        for(int i = 1; i < nums.length; i++){
            if(max <= nums[i]){
                max = nums[i];
                System.out.println(max);
                index = i;
            }
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j]*2 > max && index != j){
                p = 0;
                break;
            }
        }
        if(p == 0)
            return -1;
        else
            return index;
    }
    public static void main(String[] args){
        int[] s = {0,0,0,1};
        int a = dominantIndex(s);
        System.out.println(a);
    }
}
*/

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
/*对角线遍历
class LeetCode {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int r = matrix.length;//行长度
        int c = matrix[0].length;//列长度
        System.out.println(r);
        System.out.println(c);
        int a = 0, b = 0;//数组下标
        int[] res = new int[r * c];
        System.out.println(res.length);
        for(int i = 0; i < res.length; i++){
            res[i] = matrix[a][b];
            if ((a + b) % 2 == 0) {
                if (b == c - 1) {
                    // 往右移动一格准备向下遍历
                    a++;
                } else if (a == 0) {
                    // 往下移动一格准备向下遍历
                    b++;
                } else {
                    // 往上移动
                    a--;
                    b++;
                }
            } else {
                if (a == r - 1) {
                    // 往右移动一格准备向上遍历
                    b++;
                } else if (b == 0) {
                    // 往上移动一格准备向上遍历
                    a++;
                } else {
                    // 往下移动
                    a++;
                    b--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[][] s = {{1,2,3},{4,5,6},{7,8,9}};
        int[] s1 = findDiagonalOrder(s);
        for(int i = 0; i < s1.length; i++){
            System.out.println(s1[i]);
        }
    }
}
*/
/*螺旋矩阵,失败，边界出错
class LeetCode {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0)
            return ans;
        int rl = matrix.length;
        int cl = matrix[0].length;
        int dir = 1;
        int i = 0, j = 0;
        while(true){
            if(dir == 1){
                for(int c = 0; c < cl; c++){
                    ans.add(matrix[i][j]);
                    j++;
                }
                j--;
                i++;
                rl--;
                dir = 2;
            }
            if(dir == 2){
                for(int r = 0; r < rl; r++){
                    ans.add(matrix[i][j]);
                    i++;
                }
                i--;
                j--;
                cl--;
                dir = 3;
            }
            if(dir == 3){
                for(int c = 0; c < cl; c++){
                    ans.add(matrix[i][j]);
                    j--;
                }
                j++;
                i--;
                rl--;
                dir = 4;
            }
            if(dir == 4){
                for(int r = 0; r < rl; r++){
                    ans.add(matrix[i][j]);
                    i--;
                }
                i++;
                j++;
                cl--;
                dir = 1;
            }
            if(ans.size() == rl*cl)
                break;
        }
        return ans;
    }
    public static void main(String[] args){
        int[][] s = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> s1 = spiralOrder(s);
        for(int i = 0; i < s1.size(); i++){
            System.out.println(s1.get(i));
        }
    }
}
*/
/*二进制求和
class LeetCode {
    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int la = a.length()-1;
        int lb = b.length()-1;
        int one = 0;//进位标志
        for(int i = la, j = lb; i >= 0 || j >= 0; i--, j--){
            //a,b,进位三者之和
            int sum = one;
            //if防止两字符串长度不同
            if(i >= 0){
                sum += a.charAt(i) - '0';
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';
            }
            //计算加和后数值
            ans.append(sum % 2);
            //判断是否有进位
            if(sum >= 2)
                one = 1;
            else
                one = 0;

        }
        //判断最前端是否有进位，进行处理
        if(one == 1){
            ans.append(one);
        }
        //返回反转后的字符串
        return ans.reverse().toString();
    }
    public static void main(String[] args){
        String a = "1010" , b = "1011";
        System.out.println(addBinary(a,b));
    }
}
*/
/*实现 strStr() 函数
class LeetCode {
    public static int strStr(String haystack, String needle) {
        if(needle.length()==0)
            return 0;
        if(haystack.length() < needle.length())
            return -1;
        char[] hay = haystack.toCharArray();
        char[] n = needle.toCharArray();
        for(int i = 0; i <= hay.length - n.length; i++){
            int j = 0;
            for(j = 0; j < n.length; j++){
                if(hay[i + j] != n[j]) break;
            }
            if(j == n.length) return i;
        }
        return -1;
    }
    public static void main(String[] args){
        String a = "mississippi", b = "issipi";
        System.out.println(strStr(a,b));
    }
}
*/
/*最小公共子串
class LeetCode {
    public static int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = 0, len;
        int m = nums.length;
        int min = 0;
        int sum = nums[l];
        if(nums.length == 0)
            return 0;
        while(l <= r ){
            if(sum < s){
                r++;
            }
            else{
                len = r - l + 1;
                if(len < m)
                    m = len;
                    min = m;
                l++;
            }
            if(r >= nums.length) break;
            sum = nums[l];
            for(int i = l + 1; i <= r; i++){
                sum += nums[i];
            }
            System.out.println(sum);
        }
        return min;
    }
    public static void main(String[] args){
        int[] m = {5,1,3,5,10,7,4,9,2,8};
        System.out.print( minSubArrayLen(15,m));
    }
}
*/
class LeetCode {
    public static void moveZeroes(int[] nums) {
        int c0 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                c0++;
        }
        int j = 0;
        for(int i = 0; i < nums.length - c0; i++){
            for(; j < nums.length; j++){
                if(nums[j] != 0){
                    nums[i] = nums[j];
                    break;
                }
            }
        }
        for(int i = nums.length - c0; i < nums.length; i++){
            nums[i] = 0;
        }
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }
    }
    public static void main(String[] args){
        int[] m = {0,1,0,3,12};
        moveZeroes(m);
    }
}
