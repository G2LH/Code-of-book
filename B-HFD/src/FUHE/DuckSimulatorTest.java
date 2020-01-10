package FUHE;

public class DuckSimulatorTest {
    public  static  void  main(String []args)
    {
//        DuckSimulatorTest duckTest=  new DuckSimulatorTest();
//        duckTest.simulatortest();
          DuckSimulatorTest duckTest=  new DuckSimulatorTest();
          AbstractDuckFactory duckFactory = new CounterDuckFactory();//创建工厂，传入simulator
          duckTest.simulator(duckFactory);
    }
    void  simulator(AbstractDuckFactory duckFactory)
    {
//        Quackable mallQuackable=  new  MallardDuck(); //定义绿头鸭
//        Quackable reQuackable=  new  RedheadDuck(); //定义红头鸭
//        Quackable duckcall=  new  DuckCall(); //定义鸭鸣器
//        Quackable rubber=  new  RubberDuck(); //定义橡皮鸭

//        Quackable mallQuackable = new QuackCounter(new  MallardDuck()); //装饰者定义绿头鸭
//        Quackable reQuackable = new QuackCounter(new   RedheadDuck()); //装饰者定义红头鸭
//        Quackable duckcall = new  QuackCounter(new  DuckCall()); //装饰者定义鸭鸣器
//        Quackable rubber = new QuackCounter(new  RubberDuck()); //装饰者定义橡皮鸭
//        System.out.println("Ducksimulator with Decorator");

        Quackable mallQuackable = duckFactory.createMallardDuck();  //工厂定义绿头鸭
        Quackable reQuackable = duckFactory.createRedheadDuck();  //工厂定义红头鸭
        Quackable duckcall = duckFactory.createDuckCall();  //工厂定义鸭鸣器
        Quackable rubber = duckFactory.createRubberDuck();  //工厂定义橡皮鸭
        System.out.println( "Ducksimulator with Factory"  );

        Quackable gooseDuck=  new  GooseAdapter( new  Goose());//适配器
        System.out.println( "Ducksimulator with Adapter"  );

        //组合模式：首先将一群鸭子加入到flock中 ,这种鸭子包含了岁有的种类
        Flock flock=  new  Flock();
        flock.add(mallQuackable);
        flock.add(reQuackable);
        flock.add(duckcall);
        flock.add(rubber);
        flock.add(gooseDuck);

        //定义一群绿头鸭，仅仅含有绿头鸭
        Flock flockmallard = new Flock();
        Quackable mallardone = duckFactory.createMallardDuck();
        Quackable mallardtwo = duckFactory.createMallardDuck();
        Quackable mallardthree = duckFactory.createMallardDuck();
        Quackable mallardfour = duckFactory.createMallardDuck();
        Quackable mallardfive = duckFactory.createMallardDuck();
        flockmallard.add(mallardone);
        flockmallard.add(mallardtwo);
        flockmallard.add(mallardthree);
        flockmallard.add(mallardfour);
        flockmallard.add(mallardfive);

        //将绿头鸭群 flockmallard加入到 flock中
        flock.add(flockmallard);
        System.out.println( "整群鸭子叫："  );
        simulate(flock);
        System.out.println( "绿头鸭群叫"  );
        simulate(flockmallard);

        simulate(mallQuackable);
        simulate(reQuackable);
        simulate(duckcall);
        simulate(rubber);
        simulate(gooseDuck);//适配器
        System.out.println(  "The Duck quacked "  + QuackCounter.getQuacks()+ " times" );

    }

    void  simulate(Quackable duck)
    {
        duck.quack();
    }
}
