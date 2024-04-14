import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long start = 0;
        long end = times[times.length - 1] * (long)n;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            
            for(int time : times) {
                sum += mid / time;
            }
            
            if(sum < n) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}