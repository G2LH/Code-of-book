//package Singleton;

//public class Singleton {
//    // 利用静态变量记录Singleton类的唯一实例
//    private static Singleton uniqueInstance;
//    // 声明构造器为私有，即只有本类内才可以调用（new Singleton()）
//    private Singleton(){}
//    // 全局访问点：只有通过该类的getInstance方法才能获取到唯一实例
//    public static synchronized Singleton getInstance(){
//        if(uniqueInstance==null){
//            // 如果实例不存在，则创建实例，以此确保只有一个唯一实例
//            uniqueInstance = new Singleton();
//        }
//        return uniqueInstance;
//}
