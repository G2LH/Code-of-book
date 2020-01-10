package FUHE;
//装饰者:为每一只鸭子增加行为,统计每一只鸭子叫了多少次，即在Quack方法上需要进行装饰
public class QuackCounter implements Quackable {
    Quackable  duckQuackable ;
    static  int  numberofQuacks ;

    public  QuackCounter(Quackable duck)
    {
        this . duckQuackable  =duck;
    }


    @Override
    public  void  quack() {
        //  TODO  Auto-generated method stub
        duckQuackable .quack();
        numberofQuacks ++;
    }

    public  static  int  getQuacks()
    {
        return  numberofQuacks ;
    }
}
