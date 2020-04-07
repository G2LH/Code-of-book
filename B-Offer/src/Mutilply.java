//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
public class Mutilply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int len = len1 + len2;
        char[] res = new char[len];
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        //模拟竖式相乘
        for (int i = len1 - 1; i >= 0; i--) {
            int nu1 = n1[i] - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int nu2 = n2[j] - '0';
                res[i + j + 1] +=  nu1 * nu2;   //模拟数学乘法
            }
        }
        //进位处理
        for (int i = len - 1; i > 0; i--) {
            if (res[i] > 9) {
                res[i - 1] += res[i] / 10;   //大于10了就要进位
                res[i] %= 10;
            }
        }
        StringBuilder ans = new StringBuilder();
        int index = 0;
        //找到第一个不为0的数，开始添加
        for (int i = 0;i < res.length; i++){
            if (res[i] != 0){
                index = i;
                break;
            }
        }
        for (int i = index; i < res.length; i++){
            ans.append((char) (res[i] + '0'));
        }
        return ans.toString();
    }
}
