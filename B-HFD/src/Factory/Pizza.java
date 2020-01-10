package Factory;

import java.util.ArrayList;
/* 抽象的Pizza 超类 */
public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();
    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough ... ");
        System.out.println("Adding sauce ... ");
        System.out.println("Adding toppings : ");
        for (String string : toppings) {
            System.out.println("	" + string);
        }
    }
    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }
    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    public String getName() {
        return name;
    }
}
