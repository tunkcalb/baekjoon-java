import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : works) {
            pq.offer(num);
        }
        
        while(n != 0) {
            int now = pq.poll();
            if(now == 0) n = 0;
            else if(now == pq.peek()) {
                pq.offer(now - 1);
                n--;
            }
            else if(now - pq.peek() < n) {
                n -= now - pq.peek();
                pq.offer(pq.peek());
            }
            else {
                pq.offer(now - n);
                n = 0;
            }
        }
        
        for(long num : pq) {
            answer += num * num;
        }
        return answer;
    }
}