package Strategy;

public class FlyRocketPowered implements FlyBehavior {
    //FlyRocketPowered是FlyBehavior接口的具体实现类
    public void fly(){
        System.out.println("I'm flying with a rocket!");
    }
}
