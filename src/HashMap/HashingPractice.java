package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashingPractice {
    public static void main(String[] args) {
        HashMap<Integer, String> map= new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        System.out.println(map);
        for(Map.Entry<Integer, String> val: map.entrySet()){
            System.out.println(val.getKey());
            System.out.println(val.getValue());
        }
        Set<Integer> set=map.keySet();
        for(int s: set){
            System.out.println(s+ " " + map.get(s));
        }

    }
}
