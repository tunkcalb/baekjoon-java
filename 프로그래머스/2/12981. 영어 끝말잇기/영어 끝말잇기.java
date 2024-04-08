import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int idx = 1;
        int cnt = 1;
        int size = words.length;
        String word = words[0];
        int length = word.length();
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        set.add(word);
        for(int i = 1; i < size; i++) {
            String now = words[i];
            if(word.charAt(length - 1) != now.charAt(0) || set.contains(now)) {
                answer[0] = idx + 1;
                answer[1] = cnt / n + 1;
                return answer;
            }
            word = now;
            length = word.length();
            set.add(word);
            idx++;
            idx %= n;
            cnt++;
        }
        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
}