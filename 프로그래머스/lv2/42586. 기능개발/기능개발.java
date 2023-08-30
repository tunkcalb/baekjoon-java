import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        int length = speeds.length;
        while(true){
            if(idx >= length){
                break;
            }
            for(int i = 0; i < length; i++){
                progresses[i] += speeds[i];
            }
            int sum = 0;
            while(progresses[idx] >= 100){
                sum += 1;
                idx++;
                if(idx >= length) break;
            }
            if(sum != 0) list.add(sum);
        }
        int size = list.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}