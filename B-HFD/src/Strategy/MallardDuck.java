package Strategy;

public class MallardDuck extends Duck {
    public MallardDuck() {
        //将继承来的quackBehavior实例变量初始化成Quack类型的新实例（Quack是QuackBehavior的具体实现类）
        //在调用performQuack()时，通过Quack对象来执行
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println(" I'm a real Mallard duck");
    }
}