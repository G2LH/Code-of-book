package String;

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
