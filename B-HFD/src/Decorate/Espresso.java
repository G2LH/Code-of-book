package Decorate;
//需要装饰的对象
public class Espresso extends Beverage {
    public Espresso(){
        description = "Espresso";
    }
    public double cost(){
        return 1.99;
    }
}
