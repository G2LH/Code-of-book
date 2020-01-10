package FUHE;
//工厂模式：将创建鸭子和装饰鸭子集中在一个地方
public class DuckFactory extends AbstractDuckFactory{
    @Override
    public  Quackable createMallardDuck() {
        //  TODO  Auto-generated method stub
        return   new  MallardDuck();
    }

    @Override
    public  Quackable createRedheadDuck() {
        //  TODO  Auto-generated method stub
        return   new  RedheadDuck();
    }

    @Override
    public  Quackable createDuckCall() {
        //  TODO  Auto-generated method stub
        return   new  DuckCall();
    }

    @Override
    public  Quackable createRubberDuck() {
        //  TODO  Auto-generated method stub
        return   new  RubberDuck ();
    }
}
