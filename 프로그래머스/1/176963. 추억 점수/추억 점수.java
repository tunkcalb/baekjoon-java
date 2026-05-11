import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int len = name.length;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int photoLength = photo.length;
        for(int i = 0; i < photoLength; i++) {
            int sum = 0;
            for(String friend : photo[i]) {
                sum += map.getOrDefault(friend, 0);
            }
            answer[i] = sum;
        }
        return answer;
    }
}