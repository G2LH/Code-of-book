package Strategy;

public class MuteQuack implements QuackBehavior {
    //MuteQuack是QuackBehavior接口的具体实现类
    public void quack(){
        System.out.println("<<Silence>>");
    }
}
