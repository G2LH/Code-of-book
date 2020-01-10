package Proxy;
//表面上是调用了代理的方法，实际的执行者其实是被代理角色Star
public class Client {
    public static void main(String[] args) {
        Subject star = new Star();
        Subject proxy = new Agent(star);
        proxy.movie();
    }

}
