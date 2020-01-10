package Strategy;

public class MiniDuckSimulator {
    public static void main(String[] args){
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();

        //鸭子对象不亲自处理行为，而是委托给flyBehavior引用的对象(接口的具体实现类)
        //将继承来的flyBehavior实例变量初始化成Quack类型的新实例,在ModelDuck构造器中对flyBehavior实例变量初始化
        Duck model = new ModelDuck();
        model.performFly();
        //动态设定：将xx鸭子行为在方法中设定，而不是在xx鸭子的构造器内实例化（将继承来的flyBehavior实例变量初始化成FlyRocketPowered类型的新实例）
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
