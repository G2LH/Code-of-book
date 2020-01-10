package FUHE;
//组合模式：能够记录一群鸭叫
import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {
    ArrayList quacks = new ArrayList();
    public   void  add(Quackable duck)
    {
        quacks  .add(duck);
    }
    @Override
    public   void  quack() {
        //  TODO  Auto-generated method stub
        Iterator iterator=  quacks .iterator();
        while  (iterator.hasNext())
        {
            Quackable quackable=(Quackable)iterator.next();
            quackable.quack();
        }
    }
}
