package Proxy;
//代理角色持有被代理角色的引用，要访问被代理角色必须通过代理，负责被代理角色本职之外的职能，并且具有准入和过滤的功能
public class Agent implements Subject {
    private Subject star;

    public Agent(Subject star) {
        this.star = star;
    }

    @Override
    public void movie() {
        System.out.println(getClass().getSimpleName() + "：剧本很好，这部电影接下了");
        star.movie();
    }
}
