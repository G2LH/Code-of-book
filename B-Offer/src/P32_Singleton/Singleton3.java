package P32_Singleton;
//版本三：懒汉式变种（synchronized同步方法，支持多线程）
//特点：线程安全；synchronized而造成的阻塞致使效率低，而且很多的阻塞都是没必要的。
public class Singleton3 {
    private static Singleton3 instance = null;
    private Singleton3(){}
    public static synchronized Singleton3 getInstance(){
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
//    synchronized同步块
//    public static Singleton3 getInstance(){
//        synchronized(Singleton3.class) {
//            if (instance == null)
//                instance = new Singleton3();
//        }
//        return instance;
//    }
}
