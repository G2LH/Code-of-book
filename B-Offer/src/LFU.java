import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LFU {
    private static int capacity;
    Map<Integer,Integer> lfu1;
    Map<Integer,Integer> lfu2;
    public LFU(int capacity) {
        this.capacity = capacity;
        lfu1 = new HashMap<Integer,Integer>();
        lfu2 = new LinkedHashMap<Integer,Integer>();
    }

    public int get(int key) {
        if(lfu1.containsKey(key)){
            int freq = lfu2.remove(key);
            lfu2.put(key,freq+1);
            return lfu1.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(lfu1.containsKey(key)){
            int freq = lfu2.remove(key);
            lfu2.put(key,freq+1);
            lfu1.put(key,value);
        }else{
            if(lfu1.size() >= capacity){
                int min = Integer.MAX_VALUE;
                int key3 = key;
                for(int key2 : lfu2.keySet()){
                    if(min > lfu2.get(key2)){
                        min = lfu2.get(key2);
                        key3 = key2;
                    }
                }
                lfu1.remove(key3);
                lfu2.remove(key3);
            }
            lfu1.put(key,value);
            lfu2.put(key,1);
        }
    }
}
