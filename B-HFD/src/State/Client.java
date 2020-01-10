package State;

public class Client {
    public static void main(String[] args){
        State state = new GreenState();
        Light light = new Light(state);
        light.work();
    }
}
