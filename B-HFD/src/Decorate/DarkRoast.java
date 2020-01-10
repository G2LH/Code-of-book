package Decorate;
//需要装饰的对象
public class DarkRoast extends Beverage{
    public DarkRoast(){
        description = "Dark Roast Coffee";
    }
    public double cost(){
        return 1.59;
    }
}
