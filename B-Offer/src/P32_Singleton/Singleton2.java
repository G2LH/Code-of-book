package P32_Singleton;
//版本二：懒汉式(非线程安全)
//特点：在第一次调用获取实例方法时分配内存，实现了懒加载；非线程安全；
public class Singleton2 {
    private  static Singleton2 instance = null;
    private Singleton2(){}
    public static Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}
