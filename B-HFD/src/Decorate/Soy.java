package Decorate;
//装饰者具体组件
public class Soy extends CondimentDecorator {
    Beverage beverage;
    public Soy(Beverage beverage){
        this.beverage = beverage;
    }
    public String getDescription(){
        return beverage.getDescription() + ", Soy";
    }
    public double cost() {
        return 1.40 + beverage.cost();
    }
}
