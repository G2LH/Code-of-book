package P32_Singleton;
//通过枚举实现
//一个完美的单例需要做到：单例，懒加载，线程安全，防止反序列化产生新对象，防止反射攻击
//而枚举的特性保证了以上除了懒加载以外的所有要求，而且实现代码及其简单
//Enum的单例模式参考：http://www.jianshu.com/p/83f7958b0944
enum Singleton6 {
    instance;
    private String attribute;
    void setAttribute(String attribute){
        this.attribute = attribute;
    }
    String getAttribute(){
        return this.attribute;
    }
}
