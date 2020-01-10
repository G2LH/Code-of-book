package Iterator;
//提供一个iterator()方法
public interface Aggregate {
    public void add(Object obj);
    public void remove(Object obj);
    public Iterator iterator();
}
