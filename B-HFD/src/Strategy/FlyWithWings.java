package Strategy;

public class FlyWithWings implements FlyBehavior {
    //FlyWithWings是FlyBehavior接口的具体实现类
    public void fly(){
        System.out.println("I'm flying!");
    }
}
