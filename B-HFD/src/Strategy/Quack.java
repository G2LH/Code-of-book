package Strategy;

public class Quack implements QuackBehavior {
    //Quack是QuackBehavior接口的具体实现类
    public void quack(){
        System.out.println("Quack");
    }
}
