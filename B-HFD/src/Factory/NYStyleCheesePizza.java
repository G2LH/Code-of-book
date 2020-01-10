package Factory;

/* 具体的NYStyleCheesePizza 子类 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}
// 省略了其他的子类披萨，和NYStyleCheesePizza的实现一致
