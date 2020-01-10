package P32_Singleton;
//静态内部类，支持多线程-懒汉式
//特点：利用静态内部类（只有在出现它的引用时才被加载），完成懒加载；final保证线程安全;
//类的加载顺序：http://blog.csdn.net/u012123160/article/details/53224469
//final的作用:
//1. 在构造函数内对一个final域的写入，与随后把这个被构造对象的引用赋值给一个引用变量，这两个操作之间不能重排序。
//2. 初次读一个包含final域的对象的引用，与随后读这个final域，这两个操作之间不能重排序。
//扩展：static变量初始化遵循以下规则:
//1.静态变量会按照声明的顺序先依次声明并设置为该类型的默认值，但不赋值为初始化的值。
//2.声明完毕后,再按声明的顺序依次设置为初始化的值，如果没有初始化的值就跳过。
//static变量初始化参考：http://www.jb51.net/article/86629.htm
public class Singleton5 {
    private Singleton5(){}
    public static Singleton5 getInstance(){
        return Singleton5Holder.instance;
    }
    public static class Singleton5Holder{
        public static final Singleton5 instance = new Singleton5();
    }
}
