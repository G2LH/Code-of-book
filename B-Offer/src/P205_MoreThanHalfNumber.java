import java.util.HashMap;
import java.util.Map;
//数组中出现次数超过一半的数字
//题目要求：
//找出数组中出现次数超过数组长度一半的数字.
public class P205_MoreThanHalfNumber {
    //1.HashMap
    public static int moreThanHalfNum(int[] array){
        if(array.length == 0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        //遍历数组 将其放入HashMap里
        for(int i = 0; i < array.length; i++){
            int count = 1;
            if(map.containsKey(array[i])){
                count = map.get(array[i])+1;
            }
            map.put(array[i],count);

        }
        //遍历HashMap
        for(int key:map.keySet()){
            if(map.get(key) > array.length/2){
                return key;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        int[] data = {2,2,2,2,2,1,3,4,5};
        System.out.println(moreThanHalfNum(data));
    }
}

