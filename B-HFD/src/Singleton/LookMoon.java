package Singleton;

public class LookMoon {
        public static void main(String[] args) {

            MyFrame f1 = new MyFrame("张三看月亮");
            MyFrame f2 = new MyFrame("李四看月亮");
            f1.setBounds(10,10,360,150);
            f2.setBounds(370,10,360,150);
            f1.validate();
            f2.validate();
        }
}
