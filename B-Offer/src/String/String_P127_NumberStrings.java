package String;

//表示数值的字符串,按照A[.[B]][e|EC] 或者 .B[e|EC];A,B,C这两种模式匹配
public class String_P127_NumberStrings {
    public static  boolean isNumeric(String str) {
        if (str == null || str.length() == 0)
            return false;
        int index = 0;

        // 如果第一位是正数或者负数
        if(str.charAt(index) == '+' || str.charAt(index) =='-'){
            index++;
        }

        // 如果此时达到数组的长度，证明此时字符数组为“+”，“-”
        if(index == str.length()){
            return false;
        }
        //boolean isNumeric = true; //全局变量

        // 扫描数字部分，扫完之后，index肯定指向非整数字符或者到达数组的末尾
        index = scanInteger(str, index);
        if(index < str.length()){
            // 继续扫描后面部分
            if(str.charAt(index) == '.'){
                // 如果此时index指向字符为小数点，则继续往后判断是否为小数位
                // 从第index+1位开始继续扫描，直到扫到第一个非数字字符或者数组结尾
                index++;
                index = scanInteger(str, index);
                if(index < str.length()){
                    // 未扫描到数组尾部，此时index指向第一个非数字字符，判断是否为指数部分的开头（e或者E）
                    if(str.charAt(index) == 'e' || str.charAt(index) == 'E'){
                        // 判断e和E之后的字符是否满足指数条件
                        index++;
                        if(index == str.length()){
                            // 此时类似于“123.46e”,不是数值
                            return false;
                        }
                        else{
                            // 在不越界的情况下判断是否为指数
                            // 此时加1后还得判断数组是否越界
                            return isExponential(str, index);
                        }
                    }
                    else{
                        // index所指字符为e,E之外的字符，肯定不是数值
                        return false;
                    }
                }
                else{
                    // 扫描到数结尾，此时的数值类似“+123.456”
                    return true;
                }
            }
            else if(str.charAt(index) == 'e' || str.charAt(index) == 'E'){
                index++;
                if(index == str.length()){
                    return false;
                }
                else{
                    return isExponential(str, index);
                }
            }
            else{
                // 如果此时index指向字符所指向字符为非上述字符，则该字符数组肯定不是数值
                return false;
            }
        }
        else{
            // 已经扫描到字符串尾部，此时的字符串应为“234“
            return true;
        }
    }
    public static  int scanInteger(String str, Integer index){
        while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
            index++;
        }
        return index;
    }
    // 扫描从e之后的字符是否是指数，题目中的指数部分不允许有小数
    public static boolean isExponential(String str, int index){
        // 此时index指向e之后的第一个字符，肯定不越界，至少是length前一个字符
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            index++;
        }
        while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
            index++;
        }
        if(index == str.length()){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        System.out.println(isNumeric("+100"));//true
        System.out.println(isNumeric("5e2")); //true
        System.out.println(isNumeric("-123"));//true
        System.out.println(isNumeric("3.1416"));//true
        System.out.println(isNumeric("-1E-16"));//true
        System.out.println(isNumeric(".6"));//true
        System.out.println(isNumeric("6."));//true
        System.out.println(isNumeric("12e"));//false
        System.out.println(isNumeric("1a3.14"));//false
        System.out.println(isNumeric("1.2.3"));//false
        System.out.println(isNumeric("+-5"));//false
        System.out.println(isNumeric("12e+5.4"));//false
    }

}
