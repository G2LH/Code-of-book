package P32_Singleton;

/**

 * 分类：饿汉式，懒汉式，双检锁，静态内部类，枚举
 * 评价指标有：单例（必须），线程安全，延迟加载，防止反序列化产生新对象，防止反射攻击
 * 实现方法的选择：一般情况下直接使用饿汉式就好了，要求延迟加载时倾向于用静态内部类，涉及到反序列化创建对象或反射问题最好选择枚举
 */

public class P32_Singleton {
    public static void main(String[] args){
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton4 singleton4 = Singleton4.getInstance();
        Singleton5 singleton5 = Singleton5.getInstance();
        Singleton6 singleton6 = Singleton6.instance;
        singleton6.setAttribute("aaa");
    }
}
