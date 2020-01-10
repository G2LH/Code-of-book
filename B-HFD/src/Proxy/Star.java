package Proxy;
//真实角色
public class Star implements Subject{
    @Override
    public void movie() {
        System.out.println(getClass().getSimpleName() + "：经纪人接了一部电影，我负责拍就好");
    }
}
