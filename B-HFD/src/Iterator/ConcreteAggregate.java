package Iterator;

import java.util.*;
//具体聚合类1
public class ConcreteAggregate implements Aggregate {

    private List list = new ArrayList();

    public void add(Object obj) {
        list.add(obj);
    }

    public Iterator iterator() {
        return new ConcreteIterator(list);
    }

    public void remove(Object obj) {
        list.remove(obj);
    }
}