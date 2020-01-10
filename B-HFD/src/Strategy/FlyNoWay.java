package Strategy;

public class FlyNoWay implements FlyBehavior {
    //FlyNoWay是FlyBehavior接口的具体实现类
    public void fly(){
        System.out.println("I can't fly");
    }
}
