package Factory;

public class PizzaStoreTestDrive {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("First, I order a " + pizza.getName() + "\n");
        pizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println("Second, I order a " + pizza.getName() + "\n");
    }
}
