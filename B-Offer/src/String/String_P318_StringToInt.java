package String;
//把字符串转换成整数
//1.首先需要判断str是否为空
//2.其次需要考虑到str是否有正负符号，这里我使用一个boolean变量isNeg表示，方便最后进行返回值的变换
//3.中间来判断每个字符是否是数字
//4.然后需要考虑int的取值范围，为了确保正确，使用一个double型的变量作为中间变量，最后强转成5.int作为返回值
//6.last but not least，需要判断最后得到的中间变量是否超出int的取值范围
public class String_P318_StringToInt {
    public static int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        double num = 0;
        boolean minus = false;
        if(str.charAt(0) == '+'){
            str = str.substring(1);
        }else if(str.charAt(0) == '-'){
            str = str.substring(1);
            minus = true;
        }
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                num += Math.pow(10,str.length()-1-i)*(str.charAt(i)-'0');
            }else{
                return 0;
            }
        }
        if(minus==false){
            if(num>Integer.MAX_VALUE){
                return 0;
            }else{
                return (int)num;
            }
        }else{
            if((0-num)<Integer.MIN_VALUE){
                return 0;
            }else{
                return (int)(0-num);
            }
        }
    }
    public static void main(String[] args){
        String str = "123";
        System.out.print(StrToInt(str));
    }
}
