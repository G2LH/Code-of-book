package Strategy;

public abstract class Duck {
    //将鸭子的行为声明为接口类型
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public Duck(){
    }
    public abstract void display();
    public void performFly(){
        flyBehavior.fly();
    }
    //鸭子对象不亲自处理行为，而是委托给quackBehavior引用的对象(接口的具体实现类)
    public void performQuack(){
        quackBehavior.quack();
    }
    public void swim(){
        System.out.println("All duck float, even decoys");
    }
    //动态设定：将xx鸭子行为在方法中设定，而不是在xx鸭子的构造器内实例化（将继承来的flyBehavior实例变量初始化成fb类型的新实例）
    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }
    public void setQuackBehaviour(QuackBehavior qb){
        quackBehavior = qb;
    }
}
