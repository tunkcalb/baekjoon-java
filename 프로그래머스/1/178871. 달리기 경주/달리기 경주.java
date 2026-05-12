import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int len = players.length;
        HashMap<String, Integer> map = new HashMap<>();
        String[] answer = new String[len];
        
        for(int i = 0; i < len; i++) {
            String player = players[i];
            answer[i] = player;
            map.put(player, i);
        }
        
        for(String call : callings) {
            int idx = map.get(call);
            map.put(call, idx - 1);
            
            String name = answer[idx - 1];
            answer[idx - 1] = call;
            answer[idx] = name;
            
            map.put(name, idx);
        }
        
        return answer;
    }
}