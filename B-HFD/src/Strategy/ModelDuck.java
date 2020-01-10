package Strategy;

public class ModelDuck extends Duck {
    public ModelDuck(){
        //将继承来的quackBehavior实例变量初始化成Quack类型的新实例（Quack是QuackBehavior的具体实现类）
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
    public void display(){
        System.out.println("I'm a model duck");
    }
}
