package Iterator;
//实现迭代器接口中定义的方法，完成集合的迭代
import java.util.*;

public class ConcreteIterator implements Iterator {
    // 迭代器要集合对象进行遍历操作，自然就需要引用集合对象
    private List list = new ArrayList();
    private int cursor =0;
    public ConcreteIterator(List list){
        this.list = list;
    }
    public boolean hasNext() {
        if(cursor==list.size()){
            return false;
        }
        return true;
    }
    public Object next() {
        Object obj = null;
        if(this.hasNext()){
            obj = this.list.get(cursor++);
        }
        return obj;
    }

}
