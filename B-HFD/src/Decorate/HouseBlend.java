package Decorate;
//需要装饰的对象
public class HouseBlend extends Beverage {
    public HouseBlend(){
        description = "House Blend Coffee";
    }
    public double cost(){
        return 1.89;
    }
}
