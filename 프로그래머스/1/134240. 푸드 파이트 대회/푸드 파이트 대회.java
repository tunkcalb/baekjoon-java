import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        
        int len = food.length;
        
        for(int i = 1; i < len; i++) {
            int mount = food[i] / 2;
            
            for(int j = 0; j < mount; j++) {
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {
            int num = q.poll();
            answer += num;
            stack.push(num);
        }
        
        answer += 0;
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        return answer;
    }
}