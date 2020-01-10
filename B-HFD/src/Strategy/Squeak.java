package Strategy;

public class Squeak implements QuackBehavior {
    //squeak是QuackBehavior接口的具体实现类
    public void quack(){
        System.out.println("Squeak");
    }
}
