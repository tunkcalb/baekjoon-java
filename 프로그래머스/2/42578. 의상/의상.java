import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes) {
            String key = cloth[1];
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }
            else {
                map.put(key,1);
            }
        }
        int answer = 1;
        for(String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }
        
        return answer - 1;
    }
}