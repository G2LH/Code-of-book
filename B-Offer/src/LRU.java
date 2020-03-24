import java.util.LinkedHashMap;
import java.util.Map;

public class LRU{
    //最近使用的放在前边（最左边），最近没用的放到后边（最右边），
    // 来了一个新的数，如果内存满了，把旧的数淘汰掉，那位了方便移动数据，
    // 我们肯定不能考虑用数组，呼之欲出，就是使用链表了，解决方案：链表（处理新老关系）+哈希（查询在不在）
    //
    private static int capacity;
    Map<Integer, Integer> map;

    public LRU(int capacity){
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //先删除旧的位置，再放入新位置
        Integer value = map.remove(key);
        map.put(key, value);
        return value;
    }


    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        //超出capacity，删除最久没用的,利用迭代器，删除第一个
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}

