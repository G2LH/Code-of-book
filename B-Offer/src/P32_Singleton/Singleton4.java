package P32_Singleton;
//版本四：双检锁DCL，支持多线程-懒汉式
//特点：线程安全；多进行一次if判断，加入volatile修饰,优点是只有在第一次实例化时加锁，之后不会加锁，提升了效率，缺点写法复杂
//不加入volatile，可能出现第一个if判断不为null，但还并未执行构造函数的情况，因为java编译器会进行指令重排;
//volatile的两大作用:
//1防止编译器对被修饰变量相关代码进行指令重排；2读写操作都不会调用工作内存而是直接取主存，保证了内存可见性
//指令重排：
//instance = new Singleton4()可主要分为三步：1分配内存，2调用构造函数，3instance指向被分配的内存（此时instance不为null了）
//正常顺序为123，指令重排可能执行顺序为132，会造成已不为null但未执行构造函数的问题
//内存可见性：
//如果字段是被volatile修饰的，Java内存模型将在写操作后插入一个写屏障指令，在读操作前插入一个读屏障指令。
//这意味着：1一旦完成写入，任何访问这个字段的线程将会得到最新的；2在写入前，任何更新过的数据值是可见的，因为内存屏障会把之前的写入值都刷新到缓存。
//因此volatile可提供一定的线程安全，但不适用于写操作依赖于当前值的情况，如自增，自减
//简单来说，volatile适合这种场景：一个变量被多个线程共享，线程直接给这个变量赋值。
//还能在双检锁上进行优化，引入一个局部变量，但个人觉得效率提成并不大，不再赘述。
//volatile参考：http://blog.csdn.net/qq_29923439/article/details/51273812
public class Singleton4 {
    private volatile static Singleton4 instance = null;
    private Singleton4(){}
    public static Singleton4 getInstance(){
        if(instance == null){
            synchronized (Singleton4.class) {
                if (instance == null) {
                   instance = new Singleton4();
                }
            }
        }
        return  instance;
    }
}
