import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s);
            
        int N = st.countTokens();
        
        int max = Integer.parseInt(st.nextToken());
        int min = max;
        for(int i = 1; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        String answer = min + " " + max;
        
        return answer;
    }
}